package hu.tosad2019.groep4.designer.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.designer.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.BaseRuleI;
import hu.tosad2019.groep4.designer.domain.objects.enums.Operator;

public class AttributeCompareRuleI extends BaseRuleI {

    private boolean not;
    private String table;
    private String column;
    private Operator operator;
    private SpecifiedValue value;


    public AttributeCompareRuleI(String code, String name, String description, AttributeRuleContext context){
        super(code, name, description);

        this.not = context.getNot();
        this.table = context.getColumn().getTableName();
        this.column = context.getColumn().getName();
        this.operator = context.getOperator();
        this.value = context.getSpecifiedValue();
    }

}
