package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.io.Serializable;
import java.util.List;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }

    public List<?> findAll() throws DataAccessLayerException {
        return super.findAll(BusinessRuleModel.class);
    }

    public List<BusinessRuleModel> findByName(String name) throws DataAccessLayerException {
        return (List<BusinessRuleModel>) super.findAll(BusinessRuleModel.class, "name = '" + name + "'");
    }

    public void delete(int id) throws DataAccessLayerException, Exception {
//        super.delete(this.find(id));

        BusinessRuleModel model = this.find(id);
        if(model == null) throw new Exception("Object not found");

        super.delete(this.find(id));

    }

    public int save(BusinessRuleModel businessRuleModel) {
        return super.saveOrUpdate(businessRuleModel);
    }
}
