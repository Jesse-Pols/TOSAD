package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.interfaces.IStatementDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.designer.application.storage.objects.StatementModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class StatementDao extends AbstractDao implements BasicDao {
    public List findByRuleId(int rule_id) throws DataAccessLayerException {
        return super.findAll(StatementModel.class, "rule_id = " + rule_id);
    }
    public List<?> findByName(String name) throws DataAccessLayerException {
        return findAll(BusinessRuleTypeModel.class, "rule_id = '" + name + "'");
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
}
