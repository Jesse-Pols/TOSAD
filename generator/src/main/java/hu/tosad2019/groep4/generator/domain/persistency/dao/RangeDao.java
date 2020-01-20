package hu.tosad2019.groep4.generator.domain.persistency.dao;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.RangeModel;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IRangeDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.datainfrastructure.hibernate.DataAccessLayerException;

public class RangeDao extends AbstractDao implements IRangeDao {
    public RangeDao() {}

    public RangeModel find(int id) throws DataAccessLayerException{
        return (RangeModel) super.find(RangeModel.class, id);
    }

    public void create(RangeModel range) throws DataAccessLayerException {
        //super.saveOrUpdate(range);
        System.out.println("Saved");
    }

}
