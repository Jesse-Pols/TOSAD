package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleModel;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id);
}
