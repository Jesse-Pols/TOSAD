package hu.tosad2019.groep4.designer.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.designer.domain.objects.Column;
import hu.tosad2019.groep4.designer.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.domain.objects.SpecifiedValue;

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
