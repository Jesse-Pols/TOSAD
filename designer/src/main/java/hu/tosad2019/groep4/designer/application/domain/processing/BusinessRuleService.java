package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.PersistencyService;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleService {

    private static BusinessRuleService instance;

    private BusinessRuleService() {}

    public static BusinessRuleService getInstance() {
        if(BusinessRuleService.instance == null) {
            instance = new BusinessRuleService();
        }

        return instance;
    }

    public BusinessRule getBusinessRule(BusinessRuleContext context){
        BusinessRuleFactory factory = new BusinessRuleFactory(context);

        return factory.makeBusinessRule();
    }

    public boolean saveBusinessRule(BusinessRule rule) throws Exception{
        BusinessRuleContextFactory factory = new BusinessRuleContextFactory(rule);

        return PersistencyService.getInstance().saveBusinessRule(factory.make());
    }


    public boolean deleteBusinessRule(BusinessRule rule) throws Exception{
    	throw new Exception("Rule deletion not supported, because it has no ID");
//        return PersistencyService.getInstance().deleteBusinessRule(rule.getName());
    }

    public List<BusinessRule> getAll(){
        List<BusinessRuleContext> ruleContextList = PersistencyService.getInstance().getAllBusinessRules();
        List<BusinessRule> rules = new ArrayList<>();

        for (BusinessRuleContext context : ruleContextList ) {
            rules.add(new BusinessRuleFactory(context).makeBusinessRule());
        }

        return rules;
    }

    public List<BusinessRule> findByName(String name){
        return new ArrayList<BusinessRule>();
    }

    public List<Operator> getOperator(BusinessRuleType ruleType){
        List<Operator> operators = new ArrayList<Operator>();

        switch(ruleType){
            case AttributeRangeRule:
                operators.add(Operator.BETWEEN);
                operators.add(Operator.NOTBETWEEN);
                break;
            case AttributeCompareRule:
            case TupleCompareRule:
            case InterEntityCompareRule:
                operators.add(Operator.EQUALS);
                operators.add(Operator.NOTEQUALS);
                operators.add(Operator.GREATERTHAN);
                operators.add(Operator.GREATERTHENOREQUAL);
                operators.add(Operator.LESSTHEN);
                operators.add(Operator.LESSTHENOREQUAL);
                break;
            case AttributeListRule:
            	operators.add(Operator.EQUALS);
                operators.add(Operator.NOTEQUALS);
                break;
            default:
            	System.err.println("Businessrule \"" + ruleType + "\" has no operators.");
        }


        return operators;
    }
}
