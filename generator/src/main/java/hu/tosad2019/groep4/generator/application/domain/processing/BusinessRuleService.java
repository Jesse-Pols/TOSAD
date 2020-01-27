package hu.tosad2019.groep4.generator.application.domain.processing;

import hu.tosad2019.groep4.generator.application.storage.PersistencyService;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;

public class BusinessRuleService {
    PersistencyService persistencyService = PersistencyService.getInstance();

    public BusinessRule getRule(int id){
        BusinessRule businessRule = null;
        //persistencyService.getBusinessRuleById(id);
        return businessRule;
    }
}
