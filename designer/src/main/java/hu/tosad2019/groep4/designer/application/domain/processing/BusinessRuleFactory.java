package hu.tosad2019.groep4.designer.application.domain.processing;
import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.Range;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule.AttributeListRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class BusinessRuleFactory {
    private BusinessRuleContext ruleContext;

    public BusinessRuleFactory(BusinessRuleContext ruleContext){
        this.ruleContext = ruleContext;
    }

    public BusinessRule makeBusinessRule(){
        BusinessRule rule = null;
        switch (ruleContext.getType()){
            case AttributeCompareRule:
                rule = this.createAttributeCompareRule();
                break;
            case AttributeRangeRule:
                rule = createAttributeRangeRule();
                break;
            case AttributeListRule:
                rule = createAttributeListRule();
                break;
//            case EntityOtherRule:
//                rule = createEntityOtherRule();
//                break;
            case InterEntityCompareRule:
                rule = createInterEntityCompareRule();
                break;
//            case ModifyRule:
//                rule = createModifyRule();
//                break;
            case TupleCompareRule:
                rule = createTupleCompareRule();
                break;
//            case TupleOtherRule:
//                rule = createTupleOtherRule();
            default:
                System.err.println(ruleContext.getType() + " does not exists!");
                break;

        }
        
        return rule;
    }


    private AttributeCompareRule createAttributeCompareRule(){
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	
		Column column = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
    	boolean not = this.ruleContext.getIsNot()==1;
    	Operator operator = this.ruleContext.getOperator();
    	SpecifiedValue value = null;
    	if(this.ruleContext.getSpecifiedValues().size() > 0) value = new SpecifiedValue(this.ruleContext.getSpecifiedValues().get(0));
    	else {
    		System.err.println("[BusinessRuleFactory][ACMP] Error while filling value:");
        	System.err.println("> " + ruleContext.getSpecifiedValues());
    	}
    	AttributeCompareRuleContext context = new AttributeCompareRuleContext(column, not, operator, value);
    	return new AttributeCompareRule(type, name, failure, context);
    }


    private AttributeRangeRule createAttributeRangeRule(){
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	
        Column column = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());

        Operator operator = ruleContext.getOperator();
        Operator minValueOperator = null;
        Operator maxValueOperator = null;

        Integer minValue = 0;
        Integer maxValue = 0;

        try{
            minValue = Integer.parseInt(ruleContext.getMinValue());
            maxValue = Integer.parseInt(ruleContext.getMaxValue());
        }
        catch(Exception e){
        	System.err.println("[BusinessRuleFactory][ARNG] Error while converting values from AttributeRangeRule:");
        	System.err.println("> " + ruleContext.getMinValue() + " - " + ruleContext.getMaxValue());
        }

        if (operator == Operator.NOTBETWEEN){
            minValueOperator = Operator.LESSTHEN;
            maxValueOperator = Operator.GREATERTHAN;
        }
        else if(operator == Operator.BETWEEN){
            minValueOperator = Operator.GREATERTHAN;
            maxValueOperator = Operator.LESSTHEN;
        }

        Range range = new Range(minValue, maxValue, minValueOperator, maxValueOperator);
        AttributeRangeRuleContext context = new AttributeRangeRuleContext(true, false, column, range);
        System.out.println(context);
        return new AttributeRangeRule(type, name, failure, context);
    }

    private AttributeListRule createAttributeListRule(){
        return null;
    }

    private AttributeOtherRule createAttributeOtherRule(){
        return null;
    }

    private InterEntityCompareRule createInterEntityCompareRule(){
        return null;
    }

    private TupleCompareRule createTupleCompareRule(){
        return null;
    }
    
    private String toFriendlyType(String basic) {
    	return null;
    }
}
