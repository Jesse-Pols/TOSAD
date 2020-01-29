package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.generator.application.storage.objects.OperatorModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class OperatorDao extends AbstractDao implements BasicDao {

    public OperatorModel find(int id) throws DataAccessLayerException {
        return (OperatorModel) super.find(OperatorModel.class, id);
    }

    public List findByName(String name) throws DataAccessLayerException {
        return super.findAll(OperatorModel.class, "operator = '" + name + "'");
    }
    public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(OperatorModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }

}
