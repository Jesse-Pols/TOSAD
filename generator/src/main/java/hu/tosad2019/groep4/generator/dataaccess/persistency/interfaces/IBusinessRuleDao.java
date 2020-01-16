package hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;

public interface IBusinessRuleDao {
    BusinessRule find(int id);
}
