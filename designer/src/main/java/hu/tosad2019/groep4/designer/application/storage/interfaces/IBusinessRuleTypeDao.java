package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import javassist.NotFoundException;

public interface IBusinessRuleTypeDao {
    BusinessRuleTypeModel find(int id) throws NotFoundException;
}
