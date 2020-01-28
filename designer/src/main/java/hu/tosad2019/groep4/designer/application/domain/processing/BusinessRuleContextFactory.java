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
        this.rule = rule;
    }

    public BusinessRuleContext make(){
        BusinessRuleContext newContext = null;
        if (AttributeCompareRule.class.equals(rule.getClass())) {
            newContext = getContextFromCompareRule((AttributeCompareRule) rule);
        } else if (AttributeRangeRule.class.equals(rule.getClass())) {
            newContext = getContextFromRangeRule((AttributeRangeRule) rule);
        } else if (AttributeListRule.class.equals(rule.getClass())) {
        } else if (InterEntityCompareRule.class.equals(rule.getClass())) {
        } else if (TupleCompareRule.class.equals(rule.getClass())) {
        }

        return newContext;
    }

    private BusinessRuleContext getContextFromCompareRule(AttributeCompareRule rule){
        BusinessRuleContext newContext = new BusinessRuleContext(BusinessRuleType.AttributeCompareRule);

        newContext.setOperator(rule.getOperator());
        newContext.setFirstColumn(rule.getColumn().getName());
        newContext.setFirstTable(rule.getColumn().getTableName());
        newContext.addSpecifiedValue(rule.getSpecifiedValue().get().toString());
        return newContext;
    }

    private BusinessRuleContext getContextFromRangeRule(AttributeRangeRule rule){
        BusinessRuleContext newContext = new BusinessRuleContext(BusinessRuleType.AttributeRangeRule);

        newContext.setFirstTable(rule.getColumn().getTableName());
        newContext.setFirstColumn(rule.getColumn().getName());
        newContext.setMinValue(Integer.toString(rule.getRange().getMinValue()));
        newContext.setMaxValue(Integer.toString(rule.getRange().getMaxValue()));

        Operator minValueOperator = rule.getRange().getMinValueOperator();

        Operator operator = Operator.BETWEEN;

        if (minValueOperator == Operator.LESSTHEN)
            operator = Operator.NOTBETWEEN;

        newContext.setOperator(operator);



        return newContext;
    }
}
