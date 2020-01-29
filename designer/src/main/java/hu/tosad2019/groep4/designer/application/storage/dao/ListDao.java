package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.objects.*;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class ListDao extends AbstractDao implements BasicDao {
    public List<?> findAllByRuleId(int id) throws DataAccessLayerException {
        return super.findAll(ListModel.class, "rule_id = " + id);
    }
    public List<?> findWhere(String where) {
        return findAll(ListModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
    public ListModel find(int id) throws DataAccessLayerException {
        return (ListModel) super.find(ListModel.class, id);
    }
}
