package hu.tosad2019.groep4.generator.application.storage.dao;

import java.util.List;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.generator.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

public class SpecifiedValueDao extends AbstractDao implements BasicDao {

    public SpecifiedValueModel find(int id) throws DataAccessLayerException {
        return (SpecifiedValueModel) super.find(SpecifiedValueModel.class, id);
    }
    public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(SpecifiedValueModel.class, where);
    }

    public List<?> findAllByRuleId(int id) throws DataAccessLayerException {
        return super.findAll(SpecifiedValueModel.class, "rule_id = " + id);
    }

    public List<?> findAllByListId(int id) throws DataAccessLayerException {
        return super.findAll(SpecifiedValueModel.class, "list_id = " + id);
    }

    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
}
