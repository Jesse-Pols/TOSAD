package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.generator.application.storage.interfaces.IBusinessRuleTypeDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.AbstractDao;

public class BusinessRuleTypeDao extends AbstractDao implements IBusinessRuleTypeDao {
    public BusinessRuleTypeModel find(int id) {
        return (BusinessRuleTypeModel) super.find(BusinessRuleTypeModel.class, id);
    }
}
