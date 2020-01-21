package hu.tosad2019.groep4.designer.application.storage;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;

public class PersistencyService implements IPersistencyService {
    public BusinessRule getBusinessRuleById(int id) {

        // DAO
        BusinessRuleDao brDao = new BusinessRuleDao();

        BusinessRuleModel businessRuleModel = brDao.find(id);
        return null;

    }
}