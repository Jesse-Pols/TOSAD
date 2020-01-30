package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import oracle.net.aso.f;

public class TupleCompareRule extends BaseRule {

    private boolean not;
    private Column column1;
    private Column column2;
    private Operator operator;

    public TupleCompareRule(String code, String name, String failure, TupleCompareRuleContext context) {
    	this(code, name, failure, context, -1);
    }
    public TupleCompareRule(String code, String name, String failure, TupleCompareRuleContext context, int id) {
        super(code, name, failure, id);
        this.not = context.getNot();
        this.column1 = context.getColumn1();
        this.column2 = context.getColumn2();
        this.operator = context.getOperator();
    }
}
