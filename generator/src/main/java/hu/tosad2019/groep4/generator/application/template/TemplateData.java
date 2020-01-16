package hu.tosad2019.groep4.generator.application.template;

import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule.AttributeRangeRule;

public class TemplateData {
    public static String getTriggerName(BusinessRule rule){
        if (rule.getClass() == AttributeCompareRule.class)
            return "BRG_SOFTWARENAME_ACMP_01";
        else if(rule.getClass() == AttributeRangeRule.class)
            return "BRG_SOFTWARENAME_ARNG_01";
        else
            return "BRG_SOFTWARENAME_RULETYPE_01";
    }
}
