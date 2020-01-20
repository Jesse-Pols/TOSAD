package hu.tosad2019.groep4.generator.domain.persistency.interfaces;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.BusinessRuleModel;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id);
}
