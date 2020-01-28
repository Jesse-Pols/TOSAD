package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IListDao;
import hu.tosad2019.groep4.generator.application.storage.objects.ListModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class ListDao extends AbstractDao implements IListDao {
    public List findAllByRuleId(int id) throws DataAccessLayerException {
        return super.findAll(ListModel.class, "rule_id = " + id);
    }
}
