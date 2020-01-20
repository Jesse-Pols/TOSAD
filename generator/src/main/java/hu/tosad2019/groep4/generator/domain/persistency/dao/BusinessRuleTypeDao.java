package hu.tosad2019.groep4.generator.domain.persistency.dao;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.BusinessRuleTypeModel;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IBusinessRuleTypeDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;

public class BusinessRuleTypeDao extends AbstractDao implements IBusinessRuleTypeDao {
    public BusinessRuleTypeModel find(int id) {
        return (BusinessRuleTypeModel) super.find(BusinessRuleTypeModel.class, id);
    }
}
