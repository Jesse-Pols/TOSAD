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
        	newContext = getContextFromListRule((AttributeListRule) rule);
        } else if (rule instanceof InterEntityCompareRule) {
        	newContext = getContextFromInterEntityRule((AttributeListRule) rule);
        } else if (rule instanceof TupleCompareRule) {
        	newContext = getContextFromTupleCompareRule((AttributeListRule) rule);
        }else {
        	throw new Exception("Rule not supported");
        }

        return newContext;
        
        
    }

    private BusinessRuleContext getContextFromTupleCompareRule(AttributeListRule rule) throws Exception {
		throw new Exception("Rule not supported");
	}

	private BusinessRuleContext getContextFromInterEntityRule(AttributeListRule rule) throws Exception {
		throw new Exception("Rule not supported");
	}

	private BusinessRuleContext getContextFromCompareRule(AttributeCompareRule rule){
        BusinessRuleContext newContext = new BusinessRuleContext(BusinessRuleType.AttributeCompareRule);

        newContext.setId(rule.getId());
        newContext.setName(rule.getName());
        newContext.setOperator(rule.getOperator());
        newContext.setFirstColumnName(rule.getColumn().getName());
        newContext.setFirstTableName(rule.getColumn().getTableName());
        newContext.addSpecifiedValue(rule.getSpecifiedValue().get().toString());
        newContext.setCategory("STATIC");
        newContext.setTemplate(newContext.getType().code);
        newContext.setFailure(rule.getFailure());
        return newContext;
    }

    private BusinessRuleContext getContextFromRangeRule(AttributeRangeRule rule){
        BusinessRuleContext newContext = new BusinessRuleContext(BusinessRuleType.AttributeRangeRule);

        newContext.setId(rule.getId());
        newContext.setName(rule.getName());
        newContext.setFirstTableName(rule.getColumn().getTableName());
        newContext.setFirstColumnName(rule.getColumn().getName());
        newContext.setMinValue(Integer.toString(rule.getRange().getMinValue()));
        newContext.setMaxValue(Integer.toString(rule.getRange().getMaxValue()));
        newContext.setCategory("STATIC");
        newContext.setTemplate(newContext.getType().code);
        newContext.setFailure(rule.getFailure());
        Operator minValueOperator = rule.getRange().getMinValueOperator();

        Operator operator = Operator.BETWEEN;

        if (minValueOperator == Operator.LESSTHEN)
            operator = Operator.NOTBETWEEN;

        newContext.setOperator(operator);

        return newContext;
    }
    
    private BusinessRuleContext getContextFromListRule(AttributeListRule rule) {
    	return null;
    }
}
