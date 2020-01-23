package hu.tosad2019.groep4.designer.application.storage.interfaces;

import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;

import java.util.List;

public interface IBusinessRuleCategoryDao  {
    BusinessRuleCategoryModel find(int id);
    List<BusinessRuleCategoryModel> findByName(String name);
}
