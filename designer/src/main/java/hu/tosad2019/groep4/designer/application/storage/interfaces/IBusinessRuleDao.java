package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;

import java.util.List;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id);
    List findAll();
    List findAllByName(String name);

    void delete(int id);
}
