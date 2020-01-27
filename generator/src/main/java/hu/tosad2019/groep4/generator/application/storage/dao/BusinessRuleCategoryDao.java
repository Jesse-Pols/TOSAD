package hu.tosad2019.groep4.generator.application.storage.dao;

import hu.tosad2019.groep4.generator.application.storage.interfaces.IBusinessRuleCategoryDao;
import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.generator.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.generator.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class BusinessRuleCategoryDao extends AbstractDao implements IBusinessRuleCategoryDao {
    public BusinessRuleCategoryModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleCategoryModel) super.find(BusinessRuleCategoryModel.class, id);
    }
    public List<BusinessRuleCategoryModel> findByName(String name) throws DataAccessLayerException {
        return findAll(BusinessRuleCategoryModel.class, "name = " + name);
    }
    public void save(BusinessRuleCategoryModel businessRuleCategoryModel) throws DataAccessLayerException {
        super.saveOrUpdate(businessRuleCategoryModel);
    }
}
