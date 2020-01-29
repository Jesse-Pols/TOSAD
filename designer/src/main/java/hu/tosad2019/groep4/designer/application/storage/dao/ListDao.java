package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.interfaces.IListDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.designer.application.storage.objects.ListModel;
import hu.tosad2019.groep4.designer.application.storage.objects.RangeModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class ListDao extends AbstractDao implements BasicDao {
    public List findAllByRuleId(int id) throws DataAccessLayerException {
        return super.findAll(ListModel.class, "rule_id = " + id);
    }
    public List<?> findWhere(String where) {
        return findAll(DbColumnModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
}
