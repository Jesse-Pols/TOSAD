package hu.tosad2019.groep4.designer.dataaccess.persistency;

import hu.tosad2019.groep4.designer.domain.objects.businessrule.BusinessRule;

import javax.management.PersistentMBean;

public class OracleDbStorage implements ObjectStorage {
    @Override
    public boolean saveBusinessRule(BusinessRule rule) {
        return false;
    }

    @Override
    public BusinessRule getBusinessRule(String code) {
        return null;
    }

    @Override
    public boolean deleteBusinessRule(String code) {
        return false;
    }
}
