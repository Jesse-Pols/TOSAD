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

    public BusinessRule getBusinessRule(BusinessRuleContext context) throws Exception{
        BusinessRuleFactory factory = new BusinessRuleFactory(context);

        return factory.makeBusinessRule();
    }

    public boolean saveBusinessRule(BusinessRule rule) throws Exception{
        BusinessRuleContextFactory factory = new BusinessRuleContextFactory(rule);

        BusinessRuleContext context = factory.make();
        
        return PersistencyService.getInstance().saveBusinessRule(context);
    }


    public boolean deleteBusinessRule(BusinessRule rule) throws Exception{

        return PersistencyService.getInstance().deleteBusinessRule(rule.getId());
    }

    public List<BusinessRule> getAll() throws Exception{
        List<BusinessRuleContext> ruleContextList = PersistencyService.getInstance().getAllBusinessRules();
        List<BusinessRule> rules = new ArrayList<>();

        for (BusinessRuleContext context : ruleContextList ) {
            rules.add(new BusinessRuleFactory(context).makeBusinessRule());
        }

        return rules;
    }

    public List<BusinessRule> findByName(String name) throws Exception{
//
        List<BusinessRuleContext> businessRuleContextList =  PersistencyService.getInstance().findBusinessRuleByName(name);
        List<BusinessRule> businessRuleList = new ArrayList<>();

        for(BusinessRuleContext context : businessRuleContextList) {
            businessRuleList.add(new BusinessRuleFactory(context).makeBusinessRule());
        }

        return businessRuleList;

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
