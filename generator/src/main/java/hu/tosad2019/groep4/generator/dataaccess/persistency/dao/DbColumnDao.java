package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.DbColumn;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class DbColumnDao extends AbstractDao implements IDbColumnDao {
    public DbColumnDao() {}

    public DbColumn find(int id) throws DataAccessLayerException {
        return (DbColumn) super.find(DbColumn.class, id);
    }
}
