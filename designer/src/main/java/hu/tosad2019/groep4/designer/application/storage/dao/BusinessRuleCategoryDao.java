package hu.tosad2019.groep4.designer.application.storage.dao;

import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IBusinessRuleCategoryDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

public class BusinessRuleCategoryDao extends AbstractDao implements IBusinessRuleCategoryDao {
    public BusinessRuleCategoryModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleCategoryModel) super.find(BusinessRuleCategoryModel.class, id);
    }
	public List<BusinessRuleCategoryModel> findByName(String name) throws DataAccessLayerException {
        return (List<BusinessRuleCategoryModel>) findAll(BusinessRuleCategoryModel.class, "name = " + name);
    }
    public void save(BusinessRuleCategoryModel businessRuleCategoryModel) throws DataAccessLayerException {
        super.saveOrUpdate(businessRuleCategoryModel);
    }
}
