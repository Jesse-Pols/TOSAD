package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;

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

    public boolean deleteBusinessRule(int id) {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new, update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        if (context.getCategory() == null || context.getTemplate() == null || context.getTypeAsString() == null) {
            System.err.println("Couldn't save business type: Missing category, template or type");
            System.err.println("Can't save business rule without a business type, saveBusinessRule was aborted");
            return false;
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
        if (context.getName() == null || context.getDescription() == null || context.getFailure() == null || type == null) {
            System.err.println("Couldn't save business rule: Missing name, description, failure or type");
            return false;
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

        // Statements don't have to be unique
        








        // Check if businessrule exists
        // Check what we need to add the businessrule
        // Get what we need to add the businessrule
        // Add the businessrule

        /*
        BusinessRuleModel businessRuleModel = super.businessRuleDao.find(context.getId());
        if (businessRuleModel != null) {
            // BusinessRule already exists
            return false;
        }

        if (context.getName() == null && context.getDescription() == null && context.getFailure() == null) {
            return false;
        }

        // TODO nullcheck for context.IsNot()
        businessRuleModel = new BusinessRuleModel(context.getName(), context.getDescription(), context.getFailure(), context.getIsNot());

        BusinessRuleTypeModel businessRuleTypeModel = super.businessRuleTypeDao.find(1);
        businessRuleModel.setType(businessRuleTypeModel);

        super.businessRuleDao.save(businessRuleModel);

        return true;
        */

        return true;
    }
}