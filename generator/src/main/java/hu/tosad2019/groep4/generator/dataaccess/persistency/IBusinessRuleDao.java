package hu.tosad2019.groep4.generator.dataaccess.persistency;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;

public interface IBusinessRuleDao {
    BusinessRule getById(int id);
}
