package hu.tosad2019.groep4.designer.domain.processing;

import hu.tosad2019.groep4.designer.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class ObjectService {
    public BusinessRule getBusinessRule(BusinessRuleType type, HashMap<String, String> attributes){
        return new BusinessRuleFactory(type, attributes).MakeBusinessRule();
    }

    public boolean saveBusinessRule(BusinessRule rule){
        return false;
    }
}
