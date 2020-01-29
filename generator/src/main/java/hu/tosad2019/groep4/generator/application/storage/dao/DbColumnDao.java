package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.generator.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class DbColumnDao extends AbstractDao implements BasicDao {
    public DbColumnDao() {}

    public DbColumnModel find(int id) throws DataAccessLayerException {
        return (DbColumnModel) super.find(DbColumnModel.class, id);
    }

	public List<DbColumnModel> findByRuleId(int rule_id) {
        return (List<DbColumnModel>) super.findAll(DbColumnModel.class, "rule_id = " + rule_id);
    }
    public List<?> findWhere(String where) {
        return findAll(DbColumnModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
}
