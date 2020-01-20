package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.application.storage.objects.domainobjects.IBusinessRule;
import hu.tosad2019.groep4.designer.application.storage.PersistencyService;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class ObjectService {
    public IBusinessRule getBusinessRule(BusinessRuleType type, HashMap<String, String> attributes){
        return new BusinessRuleFactory(type, attributes).MakeBusinessRule();
    }

    public boolean saveBusinessRule(){

        return true;

    }
}
