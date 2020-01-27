package hu.tosad2019.groep4.designer.application.storage;

import java.util.List;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;


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
        @SuppressWarnings("unchecked")
		List<BusinessRuleModel> businessRuleModels = (List<BusinessRuleModel>) super.businessRuleDao.findAll();
        return super.loopThroughBusinessRules(businessRuleModels);
    }

    @SuppressWarnings("unchecked")
	public List<BusinessRuleContext> findBusinessRuleByName(String name) {
        return super.loopThroughBusinessRules((List<BusinessRuleModel>) super.businessRuleDao.findAllByName(name));
    }

    public boolean deleteBusinessRule(int id) {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new, update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        BusinessRuleCategoryModel businessRuleCategoryModel = null;
        TemplateModel templateModel = null;

        if (context.getCategory() != null) {
            businessRuleCategoryModel = new BusinessRuleCategoryModel(context.getCategory());
            super.businessRuleCategoryDao.save(businessRuleCategoryModel);
        }

        if (context.getTemplate() != null) {
            templateModel = new TemplateModel(context.getTemplate());
            super.templateDao.save(templateModel);
        }



        /*



        TemplateModel template = super.templateDao.find(context.getTemplateId());




        String typeString = super.
        BusinessRuleTypeModel businessRuleType = super.businessRuleTypeDao.find(context.getTypeId());




        BusinessRuleCategoryModel categoryModel = new BusinessRuleCategoryModel(null);


        // TODO type_id? is_not?
        BusinessRuleModel businessRuleModel = new BusinessRuleModel(context.getName(), context.getDescription(), context.getFailure(), 0,0);

        BusinessRuleTypeModel typeModel = null;

        DbColumnModel dbColumnModel = null;
        ListModel list = null;
        OperatorModel operatorModel = null;
        RangeModel rangeModel = null;
        SpecifiedValueModel specifiedValueModel = null;
        StatementModel statementModel = null;
        TemplateModel templateModel = null;

         */

        return false;
    }
}