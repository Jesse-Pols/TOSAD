package hu.tosad2019.groep4.designer.application.storage.dao;

import java.util.List;

import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.storage.interfaces.ISpecifiedValueDao;
import hu.tosad2019.groep4.designer.application.storage.objects.SpecifiedValueModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public class SpecifiedValueDao extends AbstractDao implements ISpecifiedValueDao {

    public SpecifiedValueModel find(int id) throws DataAccessLayerException, NotFoundException {
        return (SpecifiedValueModel) super.find(SpecifiedValueModel.class, id);
    }

    public List findAllByRuleId(int id) throws DataAccessLayerException {
        return super.findAll(SpecifiedValue.class, "rule_id = " + id);
    }
}
