package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.PersistencyService;

import java.util.HashMap;
import java.util.List;

public class BusinessRuleService {
    private PersistencyService persistencyService;

    public void getBusinessRule(BusinessRuleContext context){
        this.persistencyService = new PersistencyService();

        //return new BusinessRuleFactory(type, attributes).MakeBusinessRule();
    }

    public boolean saveBusinessRule(BusinessRule rule){
        return false;
    }

    public boolean deleteBusinessRule(BusinessRule rule){
        return false;
    }

    public List<Operator> getOperator(BusinessRuleType ruleType){
        return null;
    }
}
