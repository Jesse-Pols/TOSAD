package hu.tosad2019.groep4.designer.application.storage.interfaces;

import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id) throws NotFoundException;
    List<?> findAll();
    List<?> findAllByName(String name);

    void delete(int id) throws DataAccessLayerException, NotFoundException;
}
