package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;

public class PersistencyService implements IPersistencyService {
    public BusinessRule getBusinessRuleById(int id) {

        // DAO
        BusinessRuleDao brDao = new BusinessRuleDao();

        // Models
        BusinessRuleModel businessRuleModel = brDao.find(id);
        BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getType();

        // Context
        BusinessRuleContext businessRuleContext = new BusinessRuleContext();

        return null;

    }
}