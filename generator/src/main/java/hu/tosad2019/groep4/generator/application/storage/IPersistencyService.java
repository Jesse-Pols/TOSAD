package hu.tosad2019.groep4.generator.application.storage;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;

import java.util.List;

public interface IPersistencyService {
    List<BusinessRule> getAllBusinessRules();
    BusinessRule getBusinessRuleById(int id);
}
