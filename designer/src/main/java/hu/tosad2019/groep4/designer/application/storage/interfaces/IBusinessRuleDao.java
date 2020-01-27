package hu.tosad2019.groep4.designer.application.storage.interfaces;

import java.util.List;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id);
    List<?> findAll();
    List<?> findAllByName(String name);

    void delete(int id);
}
