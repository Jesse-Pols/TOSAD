package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class TupleCompareRuleContext {

    private Column column1;
    private Column column2;
    private boolean not;
    private Operator operator;

    public Column getColumn1() {
        return column1;
    }
    public Column getColumn2() {
        return column2;
    }

    public boolean getNot() {
        return not;
    }

    public Operator getOperator() {
        return operator;
    }

    public TupleCompareRuleContext(Column column1,Column column2, boolean not, Operator operator) {
        this.column1 = column1;
        this.column2 = column2;
        this.not = not;
        this.operator = operator;
    }
}
