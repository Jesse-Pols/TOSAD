package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.domain.processing.BusinessRuleService;

public class MainFacade {
    public boolean GenerateBusinessRule(int id, TargetDbContext targetDbContext){
        BusinessRuleService businessRuleService = new BusinessRuleService();

        BusinessRule rule = businessRuleService.getRule(id);

        Generator generator = new Generator(rule, targetDbContext);

        return generator.generate();
    }
}
