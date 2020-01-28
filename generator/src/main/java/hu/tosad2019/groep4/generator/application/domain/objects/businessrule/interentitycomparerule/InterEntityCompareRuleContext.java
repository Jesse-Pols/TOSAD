package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule;

import com.mysql.cj.xdevapi.Table;
import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;

public class InterEntityCompareRuleContext {

    private Column column1;
    private Column column2;
    private boolean not;
    private Operator operator;
    private Table table2;

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

    public Table getTable2() {
        return table2;
    }


    public InterEntityCompareRuleContext(Column column1,Column column2, boolean not, Operator operator, Table table2) {
        this.column1 = column1;
        this.column2 = column2;
        this.not = not;
        this.operator = operator;
        this.table2 = table2;
    }

}
