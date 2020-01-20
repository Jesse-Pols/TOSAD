package hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.attributecomparerule;

import hu.tosad2019.groep4.generator.domain.objects.processed.Column;
import hu.tosad2019.groep4.generator.domain.objects.processed.enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.processed.SpecifiedValue;

public class AttributeCompareRuleContext {
    private Column column;
    private boolean not;
    private Operator operator;
    private SpecifiedValue specifiedValue;


    public Column getColumn() {
        return column;
    }

    public boolean getNot() {
        return not;
    }

    public Operator getOperator() {
        return operator;
    }

    public SpecifiedValue getSpecifiedValue() {
        return specifiedValue;
    }

    public AttributeCompareRuleContext(Column column, boolean not, Operator operator, SpecifiedValue specifiedValue) {
        this.column = column;
        this.not = not;
        this.operator = operator;
        this.specifiedValue = specifiedValue;
    }
}
