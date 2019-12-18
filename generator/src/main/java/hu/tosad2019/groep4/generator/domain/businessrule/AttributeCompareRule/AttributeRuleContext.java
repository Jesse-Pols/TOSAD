package hu.tosad2019.groep4.generator.domain.businessrule.AttributeCompareRule;

import hu.tosad2019.groep4.generator.domain.Column;
import hu.tosad2019.groep4.generator.domain.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.SpecifiedValue;

public class AttributeRuleContext {
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

    public AttributeRuleContext(Column column, boolean not, Operator operator, SpecifiedValue specifiedValue) {
        this.column = column;
        this.not = not;
        this.operator = operator;
        this.specifiedValue = specifiedValue;
    }
}
