package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleTypeModel;

public interface IBusinessRuleTypeDao {
    BusinessRuleTypeModel find(int id);
}
