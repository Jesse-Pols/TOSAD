package hu.tosad2019.groep4.generator.application;

import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.domain.processing.ObjectService;

public class MainFacade {
    boolean GenerateBusinessRule(int id, String database){
        ObjectService objectService = new ObjectService();


        Generator generator = new Generator();
        BusinessRule rule = objectService.getBusinessRule();

        return generator.generateBusinessRule();
    }
}
