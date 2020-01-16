package hu.tosad2019.groep4.generator.domain.processing;

import hu.tosad2019.groep4.generator.dataaccess.persistency.PersistencyService;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;

public class ObjectService {
    PersistencyService persistencyService = new PersistencyService();

    public BusinessRule getBusinessRule(int id){
        BusinessRule businessRule = persistencyService.getBusinessRuleById(id);
        return businessRule;
    }
}
