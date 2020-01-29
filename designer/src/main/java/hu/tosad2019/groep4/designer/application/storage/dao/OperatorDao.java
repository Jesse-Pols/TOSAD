package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IOperatorDao;
import hu.tosad2019.groep4.designer.application.storage.objects.OperatorModel;
import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.StatementModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class OperatorDao extends AbstractDao implements IOperatorDao {

    public OperatorModel find(int id) throws DataAccessLayerException {
        return (OperatorModel) super.find(OperatorModel.class, id);
    }

    public List findByName(String name) throws DataAccessLayerException {
        return super.findAll(OperatorModel.class, "operator = '" + name + "'");
    }
}
