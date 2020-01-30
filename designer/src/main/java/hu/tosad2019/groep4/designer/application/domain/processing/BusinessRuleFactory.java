package hu.tosad2019.groep4.designer.application.domain.processing;
import java.util.ArrayList;
import java.util.List;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.Range;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule.AttributeListRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule.AttributeListRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class BusinessRuleFactory {
    private BusinessRuleContext ruleContext;

    public BusinessRuleFactory(BusinessRuleContext ruleContext){
        this.ruleContext = ruleContext;
    }

    public BusinessRule makeBusinessRule() throws Exception{
        switch (ruleContext.getType()){
            case AttributeCompareRule:
                return this.createAttributeCompareRule();
            case AttributeRangeRule:
                return createAttributeRangeRule();
            case AttributeListRule:
                return createAttributeListRule();
            case AttributeOtherRule:
            	return createAttributeOtherRule();
//            case EntityOtherRule:
//                return createEntityOtherRule();;
            case InterEntityCompareRule:
                return createInterEntityCompareRule();
//            case ModifyRule:
//                return createModifyRule();
            case TupleCompareRule:
                return createTupleCompareRule();
//            case TupleOtherRule:
//                rule = createTupleOtherRule();
            default:
                throw new Exception(ruleContext.getType() + " does not exists!");
        }
    }


    private AttributeCompareRule createAttributeCompareRule(){
    	int id = this.ruleContext.getId();
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	
		Column column = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
    	boolean not = this.ruleContext.getIsNot()==1;
    	Operator operator = this.ruleContext.getOperator();
    	SpecifiedValue value = null;
    	if(this.ruleContext.getBusinessRuleValues().size() > 0) value = new SpecifiedValue(this.ruleContext.getBusinessRuleValues().get(0));
    	else {
    		System.err.println("[BusinessRuleFactory][ACMP] Error while filling value:");
        	System.err.println("> " + ruleContext.getBusinessRuleValues());
    	}
    	AttributeCompareRuleContext context = new AttributeCompareRuleContext(column, not, operator, value);
    	return new AttributeCompareRule(type, name, failure, context, id);
    }


    private AttributeRangeRule createAttributeRangeRule(){
    	int id = this.ruleContext.getId();
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	
        Column column = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
        boolean isNot = this.ruleContext.getIsNot()==1;
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
        AttributeRangeRuleContext context = new AttributeRangeRuleContext(true, isNot, column, range);
        System.out.println(context);
        return new AttributeRangeRule(type, name, failure, context, id);
    }

    private AttributeListRule createAttributeListRule(){
    	int id = this.ruleContext.getId();
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	Column column = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
    	boolean isNot = this.ruleContext.getIsNot()==1;
    	List<String> specifieStringList = this.ruleContext.getListValues();
    	List<SpecifiedValue> specifiedValueList = new ArrayList<SpecifiedValue>();
    	Operator operator = this.ruleContext.getOperator();
    	for(String s : specifieStringList) {
    		specifiedValueList.add(new SpecifiedValue(s));
    	}
    	AttributeListRuleContext context = new AttributeListRuleContext(column, isNot, operator, specifiedValueList);
        return new AttributeListRule(type, name, failure, context, id);
    }

    private AttributeOtherRule createAttributeOtherRule(){
    	int id = this.ruleContext.getId();
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	Column column = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
    	String sqlConstraint = this.ruleContext.getSQLQuery();
    	Operator operator = this.ruleContext.getOperator();
    	AttributeOtherRuleContext context = new AttributeOtherRuleContext(column, operator, sqlConstraint);
        return new AttributeOtherRule(type, name, failure, context, id);
    }
    
    private TupleCompareRule createTupleCompareRule(){
    	int id = this.ruleContext.getId();
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	Column column1 = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
    	Column column2 = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getSecondColumnName());
    	boolean isNot = this.ruleContext.getIsNot()==1;
    	Operator operator = this.ruleContext.getOperator();
    	TupleCompareRuleContext context = new TupleCompareRuleContext(column1, column2, isNot, operator);
        return new TupleCompareRule(type, name, failure, context, id);
    }

    private InterEntityCompareRule createInterEntityCompareRule(){
    	int id = this.ruleContext.getId();
    	String name = this.ruleContext.getName();
    	String type = "[" + this.ruleContext.getType().code + "] " + this.ruleContext.getType().friendlyLabel;
    	String failure = this.ruleContext.getFailure();
    	Column column1 = new Column(this.ruleContext.getFirstTableName(), this.ruleContext.getFirstColumnName());
    	Column column2 = new Column(this.ruleContext.getSecondTableName(), this.ruleContext.getSecondColumnName());
    	String table2 = this.ruleContext.getSecondTableName();
    	boolean isNot = this.ruleContext.getIsNot()==1;
    	Operator operator = this.ruleContext.getOperator();
    	InterEntityCompareRuleContext context = new InterEntityCompareRuleContext(column1, column2, isNot, operator, table2);
        return new InterEntityCompareRule(type, name, failure, context);
    }
}
