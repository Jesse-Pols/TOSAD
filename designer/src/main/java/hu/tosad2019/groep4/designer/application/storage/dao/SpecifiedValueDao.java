package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class SpecifiedValueDao extends AbstractDao implements BasicDao {

    public SpecifiedValueModel find(int id) throws DataAccessLayerException {
        return (SpecifiedValueModel) super.find(SpecifiedValueModel.class, id);
    }
    public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(SpecifiedValueModel.class, where);
    }

    public List findByRuleId(int id) throws DataAccessLayerException {
        return this.findWhere("rule_id = " + id);
    }
    public List findAllByListId(int id) throws DataAccessLayerException {
        return this.findWhere("list_id = " + id);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
}
