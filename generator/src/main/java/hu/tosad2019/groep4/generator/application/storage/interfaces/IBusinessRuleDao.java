package hu.tosad2019.groep4.generator.application.storage.interfaces;

import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleModel;

import java.util.List;

public interface IBusinessRuleDao {
    BusinessRuleModel find(int id);
    List<?> findAll();
    List<?> findAllByName(String name);

    void delete(int id);
    int save(BusinessRuleModel businessRuleModel);
}
