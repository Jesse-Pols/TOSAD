package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.generator.application.storage.interfaces.IRangeDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.DataAccessLayerException;

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