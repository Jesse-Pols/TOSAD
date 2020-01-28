package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule;

import com.mysql.cj.xdevapi.Table;
import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;

public class InterEntityCompareRule extends BaseRule {

    private boolean not;
    private Column column1;
    private Column column2;
    private Operator operator;
    private String table2;

    public InterEntityCompareRule(String code, String name, InterEntityCompareRuleContext context) {
        super(code, name);
        this.not = context.getNot();
        this.column1 = context.getColumn1();
        this.column2 = context.getColumn2();
        this.operator = context.getOperator();
        this.table2 = context.getTable2();
    }
}
