package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class InterEntityCompareRule extends BaseRule {
    private boolean not;
    private Column column1;
    private Column column2;
    private Operator operator;




    public InterEntityCompareRule(String name, String description,InterEntityCompareRuleContext context) {

        super(name, description);
        this.not = context.getNot();
        this.column1 = context.getColumn1();
        this.column2 = context.getColumn2();
        this.operator = context.getOperator();
    }
}
