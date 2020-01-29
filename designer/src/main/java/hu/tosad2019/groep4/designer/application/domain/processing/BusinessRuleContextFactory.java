package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule.AttributeListRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

public class BusinessRuleContextFactory {
    private BusinessRule rule;

    public BusinessRuleContextFactory(BusinessRule rule){
    	if(rule == null) throw new NullPointerException("Rule may not be null");
        this.rule = rule;
    }

    public BusinessRuleContext make() throws Exception {
        BusinessRuleContext newContext = null;
        if (rule instanceof AttributeCompareRule) {
            newContext = getContextFromCompareRule((AttributeCompareRule) rule);
        } else if (rule instanceof AttributeRangeRule) {
            newContext = getContextFromRangeRule((AttributeRangeRule) rule);
        } else if (rule instanceof AttributeListRule) {
        	throw new Exception("Rule not implemented");
        } else if (rule instanceof InterEntityCompareRule) {
        	throw new Exception("Rule not implemented");
        } else if (rule instanceof TupleCompareRule) {
        	throw new Exception("Rule not implemented");
        }else {
        	throw new Exception("Rule not supported");
        }

        return newContext;
        
        
    }

    private BusinessRuleContext getContextFromCompareRule(AttributeCompareRule rule){
        BusinessRuleContext newContext = new BusinessRuleContext(BusinessRuleType.AttributeCompareRule);

        newContext.setOperator(rule.getOperator());
        newContext.setFirstColumn(rule.getColumn().getName());
        newContext.setFirstTable(rule.getColumn().getTableName());
        newContext.addSpecifiedValue(rule.getSpecifiedValue().get().toString());
        newContext.setCategory("STATIC");
        newContext.setTemplate(newContext.getType().code);
        return newContext;
    }

    private BusinessRuleContext getContextFromRangeRule(AttributeRangeRule rule){
        BusinessRuleContext newContext = new BusinessRuleContext(BusinessRuleType.AttributeRangeRule);

        newContext.setFirstTable(rule.getColumn().getTableName());
        newContext.setFirstColumn(rule.getColumn().getName());
        newContext.setMinValue(Integer.toString(rule.getRange().getMinValue()));
        newContext.setMaxValue(Integer.toString(rule.getRange().getMaxValue()));
        newContext.setCategory("STATIC");
        newContext.setTemplate(newContext.getType().code);
        Operator minValueOperator = rule.getRange().getMinValueOperator();

        Operator operator = Operator.BETWEEN;

        if (minValueOperator == Operator.LESSTHEN)
            operator = Operator.NOTBETWEEN;

        newContext.setOperator(operator);



        return newContext;
    }
}
