package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.generator.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class DbColumnDao extends AbstractDao implements IDbColumnDao {
    public DbColumnDao() {}

    public DbColumnModel find(int id) throws DataAccessLayerException {
        return (DbColumnModel) super.find(DbColumnModel.class, id);
    }

    public List<DbColumnModel> findByRuleId(int rule_id) {
        return super.findAll(DbColumnModel.class, "rule_id = 21");
    }
}
