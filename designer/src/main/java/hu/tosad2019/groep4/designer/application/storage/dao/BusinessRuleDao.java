package hu.tosad2019.groep4.designer.application.storage.dao;

import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

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

    public List<?> findByName(String name) throws DataAccessLayerException {
        return findAll(BusinessRuleTypeModel.class, "name = '" + name + "'");
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
}
