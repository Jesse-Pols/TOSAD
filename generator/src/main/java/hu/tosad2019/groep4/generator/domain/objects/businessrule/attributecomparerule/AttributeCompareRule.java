package hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;

public class AttributeCompareRule implements BusinessRule {

    private BaseRule rule;

    private boolean not;
    private String table;
    private String column;
    private Operator operator;
    private SpecifiedValue value;


    public AttributeCompareRule(BaseRule rule, AttributeRuleContext context){
        this.rule = rule;

        this.not = context.getNot();
        this.table = context.getColumn().getTableName();
        this.column = context.getColumn().getName();
        this.operator = context.getOperator();
        this.value = context.getSpecifiedValue();
    }

    @Override
    public String getCode() {
        return rule.getCode();
    }

    @Override
    public String getName() {
        return rule.getName();
    }

    @Override
    public String getDescription() {
        return rule.getDescription();
    }


}
