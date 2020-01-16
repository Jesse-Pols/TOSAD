package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.DbColumn;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.SpecifiedValue;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.ISpecifiedValueDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class SpecifiedValueDao extends AbstractDao implements ISpecifiedValueDao {
    public SpecifiedValueDao() {}

    public SpecifiedValue find(int id) throws DataAccessLayerException {
        return (SpecifiedValue) super.find(SpecifiedValue.class, id);
    }
}
