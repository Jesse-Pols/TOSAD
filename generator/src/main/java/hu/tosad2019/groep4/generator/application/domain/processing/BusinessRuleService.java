package hu.tosad2019.groep4.generator.application.domain.processing;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.Range;
import hu.tosad2019.groep4.generator.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.generator.application.storage.PersistencyService;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;

public class BusinessRuleService {
    PersistencyService persistencyService = PersistencyService.getInstance();

    public BusinessRule getRule(int id){
        BusinessRule businessRule = null;

        if (id == 1001){
            AttributeCompareRuleContext compareRuleContext = new AttributeCompareRuleContext(new Column("adres", "adresid"), false, Operator.GREATERTHAN, new SpecifiedValue(0));
            BusinessRule attributeCompareRule = new AttributeCompareRule("ACMP", "HARDCODED_ACMP_1", "value must be greater than 0", compareRuleContext);
            return attributeCompareRule;
        }
        else if (id == 1002){
            Range range = new Range(0, 10000, Operator.GREATERTHAN, Operator.LESSTHEN);

            AttributeRangeRuleContext rangeRuleContext = new AttributeRangeRuleContext(true, false, new Column("ov_chipkaart", "kaartnummer"), range);
            AttributeRangeRule attributeRangeRule = new AttributeRangeRule("ARNG", "HARDCODED_ARNG_1", "value must be between 0 and 10000", rangeRuleContext);

            return attributeRangeRule;
        }
        else{
            BusinessRuleContext ruleContext = persistencyService.getBusinessRuleById(id);

            try{
                businessRule = new BusinessRuleFactory(ruleContext).makeBusinessRule();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            return businessRule;
        }
    }
}
