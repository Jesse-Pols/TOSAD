package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }

    public List<?> findAll() throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class);
    }

    public List<?> findAllByName(String name) throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class, "name = '" + name + "'");
    }

    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }

    public int save(BusinessRuleModel businessRuleModel) {
        return (Integer) super.saveOrUpdate(businessRuleModel);
    }
}
