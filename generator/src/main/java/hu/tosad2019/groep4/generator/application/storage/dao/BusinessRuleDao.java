package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class BusinessRuleDao extends AbstractDao implements BasicDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }

    public List<?> findAll() throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class);
    }

    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }

    public List<?> findWhere(String where) throws DataAccessLayerException {
        //return findAll(BusinessRuleModel.class, "name = '" + name + "'");
        return findAll(BusinessRuleModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
}
