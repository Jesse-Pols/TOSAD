package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;

public class AttributeOtherRule extends BaseRule {

    private boolean not;
    private Column column;
    private String SQLContraint;
    private Operator operator;

    public AttributeOtherRule(String code, String name, AttributeOtherRuleContext context) {
        super(code, name);
        this.column = context.getColumn();
        this.SQLContraint = context.getSqlConstraint();
        this.operator = context.getOperator();
    }
}
