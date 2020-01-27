package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IOperatorDao;
import hu.tosad2019.groep4.generator.application.storage.objects.OperatorModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

public class OperatorDao extends AbstractDao implements IOperatorDao {

    public OperatorModel find(int id) throws DataAccessLayerException {
        return (OperatorModel) super.find(OperatorModel.class, id);
    }

}
