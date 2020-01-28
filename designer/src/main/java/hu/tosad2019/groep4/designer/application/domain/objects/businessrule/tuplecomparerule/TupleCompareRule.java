package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class TupleCompareRule extends BaseRule {
    private boolean not;
    private Column column1;
    private Column column2;
    private Operator operator;






    public TupleCompareRule(String name, String description, TupleCompareRuleContext context) {

        super(name, description);
        this.not = context.getNot();
        this.column1 = context.getColumn1();
        this.column2 = context.getColumn2();
        this.operator = context.getOperator();
    }
}
