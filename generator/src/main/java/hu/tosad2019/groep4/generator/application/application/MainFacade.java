package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.application.domain.processing.ObjectService;

public class MainFacade {
    boolean GenerateBusinessRule(int id, String dbHostName){
        ObjectService objectService = new ObjectService();

        BusinessRule rule = objectService.getBusinessRule(id);

        Generator generator = new Generator(rule);

        return generator.generateBusinessRule(dbHostName);
    }
}
