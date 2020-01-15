package hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.generator.domain.objects.Column;
import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;

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
