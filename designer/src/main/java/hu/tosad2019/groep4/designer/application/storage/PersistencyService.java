package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicModel;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

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
        return super.loopThroughBusinessRules((List<BusinessRuleModel>) super.businessRuleDao.findByName(name));
    }

    public boolean deleteBusinessRule(int id) {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new, update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        if (context.getCategory() == null || context.getTemplate() == null || context.getTypeAsString() == null) {
            throw new NullPointerException("Couldn't save business type: Missing category, template or type\nCan't save business rule without a business type, saveBusinessRule was aborted");
        }

        BasicModel category = new BusinessRuleCategoryModel(context.getCategory());
        category = super.checkAndSaveObject(category, super.businessRuleCategoryDao, context.getCategory());

        BasicModel template = new TemplateModel(context.getTemplate());
        template = super.checkAndSaveObject(template, super.templateDao, context.getTemplate());

        BasicModel type = new BusinessRuleTypeModel(context.getTypeAsString(), template, category);
        type = super.checkAndSaveObject(type, super.businessRuleTypeDao, context.getTypeAsString());

        // Extra nullcheck for businessrule
        if (context.getName() == null || context.getFailure() == null || type == null) {
            throw new NullPointerException("Couldn't save business rule: Missing name, description, failure or type");
        }

        BasicModel rule = new BusinessRuleModel(context.getName(), context.getDescription(), context.getFailure(), context.getIsNot(), type);
        rule = super.checkAndSaveObject(rule, super.businessRuleDao, context.getName());

        if (context.getStatement() != null) {
            BasicModel statement = new StatementModel(context.getStatement(), rule);
            //statement = super.checkAndSaveObject(statement, super.statementDao, context.getStatement());
        }

        // Check if there are any rulevalues in the context
        /*
        List<String> ruleValues = context.getBusinessRuleValues();
        List<SpecifiedValueModel> specifiedValues = new ArrayList<>();
        if (ruleValues.isEmpty()) {
            System.err.println("No rulevalues were found. saveBusinessRule continues...");
        } else {
            // Turn rulevalues into specified values
            for (String value : ruleValues) {
                SpecifiedValueModel specifiedValue = new SpecifiedValueModel(value);
                specifiedValue.setRule(rule);
                specifiedValues.add(specifiedValue);
            }
        }

        // Check if there are any listvalues in the context
        List<String> listValues = context.getListValues();
        if (listValues.isEmpty()) {
            System.err.println("No listvalues were found. saveBusinessRule continues...");
        } else {
            // Add list
            List<ListModel> listModels = super.listDao.findAllByRuleId(rule.getId());
            ListModel list = new ListModel(rule);
            if (listModels.isEmpty()) {
                list.setId(super.listDao.save(list));
            } else {
                System.err.println("List couldn't be saved: Already exists in the database. saveBusinessRule continues...");
                list = listModels.get(0);
            }

            // Turn listvalues into specified values
            for (String value : listValues) {
                SpecifiedValueModel specifiedValue = new SpecifiedValueModel(value);
                specifiedValue.setList(list);
                specifiedValues.add(specifiedValue);
            }
        }

        // Add every specified rule to the database
        for (SpecifiedValueModel value : specifiedValues) {
            value.setId(super.specifiedValueDao.save(value));
        }

        // Check if there are min and max operator
        if (context.getMinOperator() == null || context.getMaxValue() == null || context.getMinValue() == null || context.getMaxValue() == null) {
            System.err.println("Missing: minOperator, maxOperator, minValue or maxValue. saveBusinessRule continues...");
        } else {
            // Check if operators exist
            // Turn operators in operatormodels
            // Build rangemodel

            // Check if operators exist
            //List<OperatorModel> minOperators = super.operatorDao.findByName(context.getMinOperatorAsString());
            //List<OperatorModel> maxOperators = super.operatorDao.findByName(context.getMaxOperatorAsString());
            //OperatorModel minOperator = ;
            //OperatorModel maxOperator;
            //if (minOperators.isEmpty()) {
              //  System.err.println("The minOperator wasn't found in the database and will be added. saveBusinessRule continues...");

            //}


            //RangeModel range = new RangeModel(context.getMinValue(), context.getMaxValue(), context.getMinOperator(), context.getMaxOperator(), rule);
        }

         */


        return true;
    }
}