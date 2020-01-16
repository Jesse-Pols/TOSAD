package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range;
import hu.tosad2019.groep4.generator.dataaccess.persistency.interfaces.IRangeDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class RangeDao extends AbstractDao implements IRangeDao {
    public RangeDao() {}

    public Range find(int id) throws DataAccessLayerException{
        return (Range) super.find(Range.class, id);
    }

}
