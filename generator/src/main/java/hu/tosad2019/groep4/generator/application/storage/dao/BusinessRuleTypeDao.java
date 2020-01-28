package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IBusinessRuleTypeDao;
import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class BusinessRuleTypeDao extends AbstractDao implements IBusinessRuleTypeDao {
    public BusinessRuleTypeDao() { }

    public BusinessRuleTypeModel find(int id) {
        return (BusinessRuleTypeModel) super.find(BusinessRuleTypeModel.class, id);
    }

    public void save(BusinessRuleTypeModel businessRuleTypeModel) {
        super.saveOrUpdate(businessRuleTypeModel);
    }

    public List<?> findByName(String name) throws DataAccessLayerException {
        return super.findAll(BusinessRuleTypeModel.class, "name = '" + name + "'");
    }
}
