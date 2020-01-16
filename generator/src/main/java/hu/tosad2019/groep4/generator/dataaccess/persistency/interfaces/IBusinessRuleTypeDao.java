package hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRuleType;

public interface IBusinessRuleTypeDao {
    BusinessRuleType getById(int id);
}
