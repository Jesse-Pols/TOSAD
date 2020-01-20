package hu.tosad2019.groep4.generator.application.storage;

import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.generator.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.generator.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.generator.domain.objects.processed.Column;
import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.storage.dao.BusinessRuleDao;
import hu.tosad2019.groep4.generator.application.storage.interfaces.IBusinessRuleDao;

import java.util.List;

public class PersistencyService implements IPersistencyService{
    public List<BusinessRule> getAllBusinessRules() {
        return null;
    }
    public BusinessRule getBusinessRuleById(int id) {

        // TODO ff dit wat beter doen k

        // DAO
        IBusinessRuleDao brDao = new BusinessRuleDao();

        // Database Models
        BusinessRuleModel businessRuleModel = brDao.find(id);
        DbColumnModel dbColumnModel = businessRuleModel.getDbColumn();
        SpecifiedValueModel dbSpecifiedValueModel = businessRuleModel.getSpecifiedValue();
        BusinessRuleTypeModel businessRuleTypeModel = businessRuleModel.getBusinessRuleType();

        // Domain Models
        Column column = dbColumnModel.getColumn();


        BusinessRule businessRule = null;



        return businessRule;
    }
}
