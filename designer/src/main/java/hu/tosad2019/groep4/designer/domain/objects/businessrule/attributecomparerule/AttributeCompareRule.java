package hu.tosad2019.groep4.designer.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.designer.domain.objects.Column;
import hu.tosad2019.groep4.designer.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.domain.objects.enums.Operator;

public class AttributeCompareRule extends BaseRule {

    private boolean not;
    private Column column;
    private Operator operator;
    private SpecifiedValue value;


    public AttributeCompareRule(String code, String name, String description, AttributeCompareRuleContext context){
        super(code, name, description);

        this.not = context.getNot();
        this.column = context.getColumn();
        this.operator = context.getOperator();
        this.value = context.getSpecifiedValue();
    }

}
