package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.generator.application.domain.objects.SpecifiedValue;

public class AttributeCompareRule extends BaseRule {

    private boolean not;
    private Column column;
    private Operator operator;
    private SpecifiedValue value;

    public AttributeCompareRule(String code, String name, String failureMessage, AttributeCompareRuleContext context){
        super(code, name, failureMessage);

        this.not = context.getNot();
        this.column = context.getColumn();
        this.operator = context.getOperator();
        this.value = context.getSpecifiedValue();
    }

    public Column getColumn() {
        return this.column;
    }

    public Operator getOperator(){
        return this.operator;
    }

    public SpecifiedValue getSpecifiedValue(){
        return this.value;
    }

    public boolean getNot(){
        return not;

    }
}
