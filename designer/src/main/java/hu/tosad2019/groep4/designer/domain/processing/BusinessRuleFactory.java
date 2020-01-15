package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.dataaccess.objects.domainobjects.BusinessRule;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class BusinessRuleFactory {
    private BusinessRuleType type;
    private HashMap<String, String> attributes;

    public BusinessRuleFactory(BusinessRuleType type, HashMap<String,String> attributes){
        this.type = type;
        this.attributes = attributes;
    }

    public BusinessRule MakeBusinessRule(){
        BusinessRule rule = null;




        return rule;
    }
}
