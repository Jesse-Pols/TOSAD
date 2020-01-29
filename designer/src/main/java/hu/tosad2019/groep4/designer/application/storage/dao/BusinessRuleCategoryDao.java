package hu.tosad2019.groep4.designer.application.storage.dao;

import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.interfaces.BasicDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

public class BusinessRuleCategoryDao extends AbstractDao implements BasicDao {
    public BusinessRuleCategoryModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleCategoryModel) super.find(BusinessRuleCategoryModel.class, id);
    }
	public List<?> findWhere(String where) throws DataAccessLayerException {
        return findAll(BusinessRuleCategoryModel.class, where);
    }
    public int save(Object obj) throws DataAccessLayerException {
        return super.saveOrUpdate(obj);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
}
