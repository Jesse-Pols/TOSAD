package hu.tosad2019.groep4.designer.application.storage.dao;

import hu.tosad2019.groep4.designer.application.storage.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

public class BusinessRuleDao extends AbstractDao implements IBusinessRuleDao {
    public BusinessRuleDao() {}

    public BusinessRuleModel find(int id) throws DataAccessLayerException {
        return (BusinessRuleModel) super.find(BusinessRuleModel.class, id);
    }
}
