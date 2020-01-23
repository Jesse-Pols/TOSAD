package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleService {

    public void getBusinessRule(BusinessRuleContext context){
//        this.persistencyService = new PersistencyService();
        //return new BusinessRuleFactory(type, attributes).MakeBusinessRule();
    }

    public boolean saveBusinessRule(BusinessRule rule){

        return false;
    }

    public boolean deleteBusinessRule(BusinessRule rule){
        return false;
    }

    public List<BusinessRule> getAll(){
        return new ArrayList<BusinessRule>();
    }

    public List<BusinessRule> findByName(String name){
        return new ArrayList<BusinessRule>();
    }

    public List<Operator> getOperator(BusinessRuleType ruleType){
        List<Operator> operators = new ArrayList<Operator>();

        switch(ruleType){
            case AttributeRangeRule:{
                operators.add(Operator.BETWEEN);
                operators.add(Operator.NOTBETWEEN);
                break;
            }
            default:{
                operators.add(Operator.EQUALS);
                operators.add(Operator.NOTEQUALS);
                operators.add(Operator.GREATERTHAN);
                operators.add(Operator.GREATERTHENOREQUAL);
                operators.add(Operator.LESSTHEN);
                operators.add(Operator.LESSTHENOREQUAL);
                break;
            }
        }


        return operators;
    }
}
