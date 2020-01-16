package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class RangeDao extends AbstractDao {

    public RangeDao() {}

    public void create(Range range) throws DataAccessLayerException {
        super.saveOrUpdate(range);
    }

}
