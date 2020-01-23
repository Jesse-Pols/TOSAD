package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleCategoryDao;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.dao.DbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.objects.*;

import java.util.List;

public class PersistencyService extends AbstractPersistency implements IPersistencyService {

    public BusinessRuleContext getBusinessRuleById(int id) {
        return super.convertIdToContext(id);
    }

    public List<BusinessRuleContext> getAllBusinessRules() {
        return super.loopThroughBusinessRules(super.businessRuleDao.findAll());
    }

    public List<BusinessRuleContext> findBusinessRuleByName(String name) {
        return super.loopThroughBusinessRules(super.businessRuleDao.findAllByName(name));
    }

    public boolean deleteBusinessRule(int id) {
        super.businessRuleDao.delete(id);
        return true;
    }

    // Insert if new update if exists
    public boolean saveBusinessRule(BusinessRuleContext context){

        List<BusinessRuleCategoryModel> categories = super.businessRuleCategoryDao.findByName(context.getCategory());

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

        return false;
    }
}