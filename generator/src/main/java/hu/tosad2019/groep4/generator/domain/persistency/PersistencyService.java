package hu.tosad2019.groep4.generator.domain.persistency;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.BusinessRuleModel;
import hu.tosad2019.groep4.generator.domain.objects.hibernated.BusinessRuleTypeModel;
import hu.tosad2019.groep4.generator.domain.objects.hibernated.DbColumnModel;
import hu.tosad2019.groep4.generator.domain.objects.hibernated.SpecifiedValueModel;
import hu.tosad2019.groep4.generator.domain.objects.processed.Column;
import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.domain.persistency.dao.BusinessRuleDao;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IBusinessRuleDao;

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
