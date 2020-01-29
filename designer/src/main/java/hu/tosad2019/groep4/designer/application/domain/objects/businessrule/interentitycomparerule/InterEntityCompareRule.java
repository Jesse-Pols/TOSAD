package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.interentitycomparerule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class InterEntityCompareRule extends BaseRule {

    private boolean not;
    private Column column1;
    private Column column2;
    private Operator operator;
    private String table2;

    public InterEntityCompareRule(String code, String name, String failure, InterEntityCompareRuleContext context) {
        super(code, name, failure);
        this.not = context.getNot();
        this.column1 = context.getColumn1();
        this.column2 = context.getColumn2();
        this.operator = context.getOperator();
        this.table2 = context.getTable2();
    }
}
