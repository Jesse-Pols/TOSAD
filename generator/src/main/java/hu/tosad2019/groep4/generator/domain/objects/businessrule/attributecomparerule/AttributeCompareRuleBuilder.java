package hu.tosad2019.groep4.generator.domain.objects.businessrule.attributecomparerule;

import hu.tosad2019.groep4.generator.domain.objects.Column;
import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BaseRule;

public class AttributeCompareRuleBuilder {

    private String ruleCode;
    private String ruleName;
    private String ruleDescription;

    private boolean not;
    private String table;
    private String column;
    private Operator operator;
    private SpecifiedValue value;

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setValue(SpecifiedValue value) {
        this.value = value;
    }

    public AttributeCompareRuleBuilder(){

    }


    public AttributeCompareRule build(){

        BaseRule rule = new BaseRule(ruleCode, ruleName, ruleDescription);
        Column column = new Column(this.table, this.column);
        AttributeRuleContext context = new AttributeRuleContext(column, not, operator, value);

        return new AttributeCompareRule(rule, context);
    }
}
