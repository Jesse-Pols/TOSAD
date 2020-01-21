package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.generator.application.storage.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

public class DbColumnDao extends AbstractDao implements IDbColumnDao {
    public DbColumnDao() {}

    public DbColumnModel find(int id) throws DataAccessLayerException {
        return (DbColumnModel) super.find(DbColumnModel.class, id);
    }
}
