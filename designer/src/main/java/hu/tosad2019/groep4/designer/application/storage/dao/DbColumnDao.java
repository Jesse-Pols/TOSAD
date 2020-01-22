package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import hu.tosad2019.groep4.designer.dataaccess.storage.HibernateFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

public class DbColumnDao extends AbstractDao implements IDbColumnDao {
    public DbColumnDao() {}

    public DbColumnModel find(int id) throws DataAccessLayerException {
        return (DbColumnModel) super.find(DbColumnModel.class, id);
    }

    public List<DbColumnModel> findByRuleId(int rule_id) {
        return super.findAll(DbColumnModel.class, "rule_id = 21");
    }
}
