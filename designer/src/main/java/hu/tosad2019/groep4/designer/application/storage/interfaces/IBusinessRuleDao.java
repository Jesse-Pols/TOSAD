package hu.tosad2019.groep4.designer.application.storage.interfaces;

import java.io.Serializable;
import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id);
    List<?> findAll();
    List<?> findByName(String name);

    void delete(int id) throws Exception;
    int save(BusinessRuleModel businessRuleModel);
}
