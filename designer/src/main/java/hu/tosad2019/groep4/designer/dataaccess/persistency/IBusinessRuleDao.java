package hu.tosad2019.groep4.designer.dataaccess.persistency;

import hu.tosad2019.groep4.designer.dataaccess.objects.dataaccesobjects.BusinessRule;

public interface IBusinessRuleDao {
    void save(BusinessRule businessRule);
}
