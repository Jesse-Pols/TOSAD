package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class BusinessRuleFactory {
    BusinessRuleType type;
    HashMap<String, String> attributes;

    BusinessRuleFactory(BusinessRuleType type, HashMap<String,String> attributes){
        this.type = type;
        this.attributes = attributes;
    }

    BusinessRule MakeBusinessRule(){
        BusinessRule rule = null;




        return rule;
    }
}
