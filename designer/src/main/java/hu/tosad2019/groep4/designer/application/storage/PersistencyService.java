package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

import java.util.ArrayList;
import java.util.List;


public class PersistencyService extends AbstractPersistency implements IPersistencyService {

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

    public boolean deleteBusinessRule(int id) throws Exception {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new, update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        if (context.getCategory() == null || context.getTemplate() == null || context.getTypeAsString() == null) {
            throw new NullPointerException("Couldn't save business type: Missing category, template or type\nCan't save business rule without a business type, saveBusinessRule was aborted");
        }

        // Check if category exists, save it if it doesn't
        List<BusinessRuleCategoryModel> categories = super.businessRuleCategoryDao.findByName(context.getCategory());
        BusinessRuleCategoryModel category = new BusinessRuleCategoryModel(context.getCategory());
        if (categories.isEmpty()) {
            super.businessRuleCategoryDao.save(category);
        } else {
            System.err.println("Category couldn't be saved: Already exists in the database.");
            category = categories.get(0);
        }

        // Check if template exists, save it if it doesn't
        List<TemplateModel> templates = super.templateDao.findByValue(context.getTemplate());
        TemplateModel template = new TemplateModel(context.getTemplate());
        if (templates.isEmpty()) {
            template.setId(super.templateDao.save(template));
        } else {
            System.err.println("Template couldn't be saved: Already exists in the database. saveBusinessRule continues...");
            template = templates.get(0);
        }

        // Check if type exists, save it if it doesn't
        List<?> types = super.businessRuleTypeDao.findByName(context.getTypeAsString());
        BusinessRuleTypeModel type = new BusinessRuleTypeModel(context.getTypeAsString(), template, category);
        if (types.isEmpty()) {
            type.setId(super.businessRuleTypeDao.save(type));
        } else {
            System.err.println("Type couldn't be saved: Already exists in the database. saveBusinessRule continues...");
            type = (BusinessRuleTypeModel) types.get(0);
        }

        // Extra nullcheck for businessrule
        if (context.getName() == null || context.getFailure() == null || type == null) {
            throw new NullPointerException("Couldn't save business rule: Missing name, description, failure or type");
        }

        // Check if businessrule exists, save it if it doesn't
        List<BusinessRuleModel> businessRules = super.businessRuleDao.findByName(context.getName());
        BusinessRuleModel rule = new BusinessRuleModel(context.getName(), context.getDescription(), context.getFailure(), context.getIsNot(), type);
        if (businessRules.isEmpty()) {
            rule.setId(super.businessRuleDao.save(rule));
        } else {
            System.err.println("Business Rule couldn't be saved: Already exists in the database. saveBusinessRule continues...");
            rule = businessRules.get(0);
        }

        if (rule == null) {
            throw new NullPointerException("Rule may not be null");
        }

        if (context.getStatement() == null) {
        	throw new NullPointerException("Statement may not be null");
        }

        // A businessrule can only have one statement
        List<StatementModel> statements = super.statementDao.findByRuleId(rule.getId());
        StatementModel statement = new StatementModel(context.getStatement(), rule);
        if (statements.isEmpty()) {
            statement.setId(super.statementDao.save(statement));
        } else {
            System.err.println("Statement couldn't be saved: Already exists in the database. saveBusinessRule continues...");
            statement = statements.get(0);
        }

        // Check if there are any rulevalues in the context
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

        return true;
    }
}