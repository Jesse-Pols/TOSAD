package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleTypeModel;
import hu.tosad2019.groep4.generator.application.storage.objects.StatementModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class StatementDao extends AbstractDao implements BasicDao {
    public List<?> findByRuleId(int rule_id) throws DataAccessLayerException {
        return this.findWhere("rule_id = " + rule_id);
    }
    public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(StatementModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
    public StatementModel find(int id) throws DataAccessLayerException {
        return (StatementModel) super.find(StatementModel.class, id);
    }
}
