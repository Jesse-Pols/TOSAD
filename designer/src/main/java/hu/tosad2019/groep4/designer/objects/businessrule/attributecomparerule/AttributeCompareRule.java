package hu.tosad2019.groep4.designer.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.designer.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.objects.enums.Operator;

public class AttributeCompareRule extends BaseRule {

    private boolean not;
    private String table;
    private String column;
    private Operator operator;
    private SpecifiedValue value;


    public AttributeCompareRule(String code, String name, String description, AttributeRuleContext context){
        super(code, name, description);

        this.not = context.getNot();
        this.table = context.getColumn().getTableName();
        this.column = context.getColumn().getName();
        this.operator = context.getOperator();
        this.value = context.getSpecifiedValue();
    }

}
