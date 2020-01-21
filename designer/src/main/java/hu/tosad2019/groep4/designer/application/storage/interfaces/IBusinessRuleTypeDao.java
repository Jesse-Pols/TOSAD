package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;

public interface IBusinessRuleTypeDao {
    BusinessRuleTypeModel find(int id);
}
