package hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRuleCategory;

public interface IBusinessRuleCategoryDao {
    BusinessRuleCategory getById(int id);
}