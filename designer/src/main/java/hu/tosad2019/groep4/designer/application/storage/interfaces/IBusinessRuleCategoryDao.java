package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.DataAccessLayerException;
import javassist.NotFoundException;

import java.util.List;

public interface IBusinessRuleCategoryDao  {
    BusinessRuleCategoryModel find(int id) throws DataAccessLayerException, NotFoundException;
    List<BusinessRuleCategoryModel> findByName(String name);
    void save(BusinessRuleCategoryModel businessRuleCategoryModel);
}
