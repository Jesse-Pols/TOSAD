package hu.tosad2019.groep4.generator.domain.persistency.dao;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.BusinessRuleModel;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }
}
