package hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.attributecomparerule;

import hu.tosad2019.groep4.generator.domain.objects.processed.Column;
import hu.tosad2019.groep4.generator.domain.objects.processed.enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.processed.SpecifiedValue;
import hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.BaseRule;

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
