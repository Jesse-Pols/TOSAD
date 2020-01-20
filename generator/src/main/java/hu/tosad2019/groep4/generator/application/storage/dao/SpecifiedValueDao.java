package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.generator.application.storage.interfaces.ISpecifiedValueDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.hibernate.DataAccessLayerException;

public class SpecifiedValueDao extends AbstractDao implements ISpecifiedValueDao {
    public SpecifiedValueDao() {}

    public SpecifiedValueModel find(int id) throws DataAccessLayerException {
        return (SpecifiedValueModel) super.find(SpecifiedValueModel.class, id);
    }
}
