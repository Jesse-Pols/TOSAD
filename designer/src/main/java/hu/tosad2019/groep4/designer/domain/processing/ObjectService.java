package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class ObjectService {
    public void getBusinessRule(BusinessRuleType type, HashMap<String, String> attributes){
        //return new BusinessRuleFactory(type, attributes).MakeBusinessRule();
    }

    public boolean saveBusinessRule(){

        return true;

    }
}
