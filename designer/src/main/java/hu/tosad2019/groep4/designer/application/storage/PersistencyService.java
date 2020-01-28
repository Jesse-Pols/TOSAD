package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;

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
        return super.loopThroughBusinessRules((List<BusinessRuleModel>) super.businessRuleDao.findAllByName(name));
    }

    public boolean deleteBusinessRule(int id) {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new, update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        if (context.getCategory() == null) {
            return false;
        }

        BusinessRuleCategoryModel category = new BusinessRuleCategoryModel(context.getCategory());
        super.businessRuleCategoryDao.save(category);
        List<BusinessRuleCategoryModel> categories = super.businessRuleCategoryDao.findByName(context.getCategory());
        if (!categories.isEmpty()) {
            category = categories.get(0);
        }






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