package hu.tosad2019.groep4.generator.application.storage.interfaces;


import hu.tosad2019.groep4.generator.application.storage.objects.BusinessRuleCategoryModel;

import java.util.List;

public interface IBusinessRuleCategoryDao  {
    BusinessRuleCategoryModel find(int id);
    List<BusinessRuleCategoryModel> findByName(String name);
    int save(BusinessRuleCategoryModel businessRuleCategoryModel);
}
