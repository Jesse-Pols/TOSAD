package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IStatementDao;
import hu.tosad2019.groep4.generator.application.storage.objects.StatementModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class StatementDao extends AbstractDao implements IStatementDao {
    public List findAllByRuleId(int rule_id) throws DataAccessLayerException {
        return super.findAll(StatementModel.class, "rule_id = " + rule_id);
    }
}
