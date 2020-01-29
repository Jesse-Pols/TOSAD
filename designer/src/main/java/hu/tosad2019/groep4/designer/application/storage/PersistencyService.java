package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicModel;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

import java.util.ArrayList;
import java.util.List;


public class PersistencyService extends AbstractPersistency {

    private static PersistencyService instance;

    private PersistencyService() {}

    public static PersistencyService getInstance() {
        if(PersistencyService.instance == null) {
            instance = new PersistencyService();
        }

        return instance;
    }

    public BusinessRuleContext getBusinessRuleById(int id) {
        return super.convertIdToContext(id);
    }

    public List<BusinessRuleContext> getAllBusinessRules() {
		List<BusinessRuleModel> businessRuleModels = (List<BusinessRuleModel>) super.businessRuleDao.findAll();
        return super.loopThroughBusinessRules(businessRuleModels);
    }

	public List<BusinessRuleContext> findBusinessRuleByName(String name) {
        return super.loopThroughBusinessRules((List<BusinessRuleModel>) super.businessRuleDao.findWhere("name='" + name + "'"));
    }

    public boolean deleteBusinessRule(int id) throws Exception {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new, update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        if (context.getCategory() == null || context.getTemplate() == null || context.getTypeAsString() == null) {
            throw new NullPointerException("Couldn't save business type: Missing category, template or type\nCan't save business rule without a business type, saveBusinessRule was aborted");
        }

        BasicModel category = new BusinessRuleCategoryModel(context.getCategory());
        category = super.checkAndSaveObject(category, super.businessRuleCategoryDao, "name='" + context.getCategory() + "'");

        BasicModel template = new TemplateModel(context.getTemplate());
        template = super.checkAndSaveObject(template, super.templateDao, "value='" + context.getTemplate() + "'");

        BasicModel type = new BusinessRuleTypeModel(context.getTypeAsString(), template, category);
        type = super.checkAndSaveObject(type, super.businessRuleTypeDao, "name='" + context.getTypeAsString() + "'");

        // Extra nullcheck for businessrule
        if (context.getName() == null || context.getFailure() == null || type == null) {
            throw new NullPointerException("Couldn't save business rule: Missing name, description, failure or type");
        }

        BasicModel rule = new BusinessRuleModel(context.getName(), context.getDescription(), context.getFailure(), context.getIsNot(), type);
        rule = super.checkAndSaveObject(rule, super.businessRuleDao, "name='" + context.getName() + "'");

        // DBCOLUMN
        if (context.getFirstColumnName() != null && context.getFirstTableName() != null) {
            BasicModel firstColumn = new DbColumnModel(context.getFirstColumnName(), context.getFirstTableName(), rule, 0);
            firstColumn = super.checkAndSaveObject(firstColumn, super.dbColumnDao, "rule_id=" + rule.getId() + "AND position=0");
        }

        if (context.getSecondColumnName() != null && context.getSecondTableName() != null) {
            BasicModel secondColumn = new DbColumnModel(context.getSecondColumnName(), context.getSecondTableName(), rule, 1);
            secondColumn = super.checkAndSaveObject(secondColumn, super.dbColumnDao, "rule_id=" + rule.getId() + "AND position=1");
        }

        // All specified Values:
        List<SpecifiedValueModel> specifiedValues = new ArrayList<>();

        // Are there any rulevalues or listvalues?
        List<String> ruleValues = context.getBusinessRuleValues();
        List<String> listValues = context.getListValues();

        if (!ruleValues.isEmpty()) {
            for (String value : ruleValues) {
                specifiedValues.add(new SpecifiedValueModel(value, (BusinessRuleModel) rule));
            }
        }

        if (!listValues.isEmpty()) {
            BasicModel list = new ListModel(rule);
            list = super.checkAndSaveObject(list, super.listDao, "rule_id=" + rule.getId());
            for (String value : listValues) {
                SpecifiedValueModel specifiedValue = new SpecifiedValueModel(value, (ListModel) list);
                specifiedValues.add(specifiedValue);
            }
        }

        // Add every specified rule to the database
        for (SpecifiedValueModel value : specifiedValues) {
            value.setId(super.specifiedValueDao.save(value));
        }

        if (context.getMinOperatorAsString() != null || context.getMaxOperatorAsString() != null) {
            BasicModel minOperator = new OperatorModel(context.getMinOperatorAsString(), rule);
            minOperator = super.checkAndSaveObject(minOperator, super.operatorDao, "operator='" + context.getMinOperatorAsString() + "'");

            BasicModel maxOperator = new OperatorModel(context.getMaxOperatorAsString(), rule);
            maxOperator = super.checkAndSaveObject(maxOperator, super.operatorDao, "operator='" + context.getMaxOperatorAsString() + "'");

            if (context.getMaxValue() != null || context.getMinValue() != null) {
                BasicModel range = new RangeModel(context.getMinValue(), context.getMaxValue(), minOperator, maxOperator, rule);
                range = super.checkAndSaveObject(range, super.rangeDao, "rule_id=" + rule.getId());
            }
        }

        if (context.getOperator() != null) {
            BasicModel operator = new OperatorModel(context.getOperatorAsString(), rule);
            operator = super.checkAndSaveObject(operator, super.operatorDao, "operator='" + context.getOperatorAsString() + "'");
        }

        return true;
    }
}