package hu.tosad2019.groep4.generator.application.storage;

import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BusinessRule;

import java.util.List;

public interface IPersistencyService {
    List<BusinessRule> getAllBusinessRules();
    BusinessRule getBusinessRuleById(int id);
}
