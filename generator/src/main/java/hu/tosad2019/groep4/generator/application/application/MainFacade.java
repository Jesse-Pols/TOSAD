package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.generator.application.domain.processing.BusinessRuleService;

public class MainFacade {
    public boolean GenerateBusinessRule(int id, TargetDbContext targetDbContext){
       //BusinessRuleService businessRuleService = new BusinessRuleService();


        //START create example rule
        AttributeCompareRuleContext context = new AttributeCompareRuleContext(new Column("adres", "adresid"), false, Operator.GREATERTHAN, new SpecifiedValue(0));
        BusinessRule attributeCompareRule = new AttributeCompareRule("ACMP", "id > 0", context);

        attributeCompareRule.setId(100);
        //END


        //BusinessRule rule = businessRuleService.getRule(id);

        BusinessRule rule = attributeCompareRule;

        Generator generator = new Generator(rule, targetDbContext);

        return generator.generate();
    }
}
