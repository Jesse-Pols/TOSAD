package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.generator.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class RangeDao extends AbstractDao implements BasicDao {

    public RangeModel find(int id) throws DataAccessLayerException {
        return (RangeModel) super.find(RangeModel.class, id);
    }

    public List findAllByRuleId(int id) throws DataAccessLayerException {
        return this.findWhere("rule_id = " + id);
    }
    public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(RangeModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }

}
