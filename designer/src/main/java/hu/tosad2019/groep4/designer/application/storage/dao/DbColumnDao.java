package hu.tosad2019.groep4.designer.application.storage.dao;

import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IDbColumnDao;
import hu.tosad2019.groep4.designer.application.storage.objects.DbColumnModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public class DbColumnDao extends AbstractDao implements IDbColumnDao {
    public DbColumnDao() {}

    public DbColumnModel find(int id) throws DataAccessLayerException, NotFoundException {
        return (DbColumnModel) super.find(DbColumnModel.class, id);
    }

    @SuppressWarnings("unchecked")
	public List<DbColumnModel> findByRuleId(int rule_id) {
        return (List<DbColumnModel>) super.findAll(DbColumnModel.class, "rule_id = 21");
    }
}
