package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.dataaccess.objects.domainobjects.IBusinessRule;
import hu.tosad2019.groep4.designer.dataaccess.persistency.PersistencyService;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class ObjectService {
    public IBusinessRule getBusinessRule(BusinessRuleType type, HashMap<String, String> attributes){
        return new BusinessRuleFactory(type, attributes).MakeBusinessRule();
    }

    public boolean saveBusinessRule(IBusinessRule rule){

        PersistencyService ps = new PersistencyService();
        ps.saveBusinessRule(rule);
        return true;

    }
}
