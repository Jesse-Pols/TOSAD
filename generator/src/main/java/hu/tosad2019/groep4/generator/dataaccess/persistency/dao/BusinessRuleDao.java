package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRule find(int id) throws DataAccessLayerException {
        return (BusinessRule) super.find(BusinessRule.class, id);
    }
}
