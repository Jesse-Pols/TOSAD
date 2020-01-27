package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IRangeDao;
import hu.tosad2019.groep4.generator.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class RangeDao extends AbstractDao implements IRangeDao {

    public RangeModel find(int id) throws DataAccessLayerException {
        return (RangeModel) super.find(RangeModel.class, id);
    }

    public List findAllByRuleId(int id) throws DataAccessLayerException {
        return super.findAll(RangeModel.class, "rule_id = " + id);
    }

}
