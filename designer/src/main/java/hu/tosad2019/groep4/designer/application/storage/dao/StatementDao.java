package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IStatementDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.StatementModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class StatementDao extends AbstractDao implements IStatementDao {
    public List findByRuleId(int rule_id) throws DataAccessLayerException {
        return super.findAll(StatementModel.class, "rule_id = " + rule_id);
    }
    public int save(StatementModel statementModel) {
        return super.saveOrUpdate(statementModel);
    }
}
