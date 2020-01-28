package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;

import java.util.List;

public class AttributeOtherRuleContext {

    private Column column;
    private Operator operator;
    private String sqlConstraint;

    public Column getColumn() {
        return column;
    }
    public Operator getOperator() {
        return operator;
    }
    public String getSqlConstraint() {
        return sqlConstraint;
    }

    public AttributeOtherRuleContext(Column column, Operator operator, String sqlConstraint) {
        this.column = column;
        this.operator = operator;
        this.sqlConstraint = sqlConstraint;
    }

}
