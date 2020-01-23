package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }

    public List findAll() throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class);
    }

    public List findAllByName(String name) throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class, "name = " + name);
    }

    public void delete(int id) throws DataAccessLayerException {
        super.delete(this.find(id));
    }
}
