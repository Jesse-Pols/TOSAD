package hu.tosad2019.groep4.generator.domain.persistency.dao;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.DbColumnModel;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class DbColumnDao extends AbstractDao implements IDbColumnDao {
    public DbColumnDao() {}

    public DbColumnModel find(int id) throws DataAccessLayerException {
        return (DbColumnModel) super.find(DbColumnModel.class, id);
    }
}
