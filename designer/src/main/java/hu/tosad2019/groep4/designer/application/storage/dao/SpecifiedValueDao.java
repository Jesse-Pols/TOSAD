package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.ISpecifiedValueDao;
import hu.tosad2019.groep4.designer.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

public class SpecifiedValueDao extends AbstractDao implements ISpecifiedValueDao {
    public SpecifiedValueDao() {}

    public SpecifiedValueModel find(int id) throws DataAccessLayerException {
        return (SpecifiedValueModel) super.find(SpecifiedValueModel.class, id);
    }
}
