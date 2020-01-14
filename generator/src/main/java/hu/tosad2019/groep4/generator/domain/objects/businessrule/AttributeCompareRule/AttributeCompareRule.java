package hu.tosad2019.groep4.generator.domain.objects.businessrule.AttributeCompareRule;

import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;

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
