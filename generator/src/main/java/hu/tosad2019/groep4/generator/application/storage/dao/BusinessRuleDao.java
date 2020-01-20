package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.generator.application.storage.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.DataAccessLayerException;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }
}