package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

import java.util.List;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws NotFoundException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }

    public List<?> findAll() throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class);
    }

    public List<?> findAllByName(String name) throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class, "name = " + name);
    }

    public void delete(int id) throws DataAccessLayerException, NotFoundException {
        super.delete(this.find(id));
    }
}
