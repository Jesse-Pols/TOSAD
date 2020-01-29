package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BaseRule;

public class AttributeOtherRule extends BaseRule {

    private Column column;
    private String SQLContraint;

    public AttributeOtherRule(String code, String name, String failureMessage, AttributeOtherRuleContext context) {
        super(code, name, failureMessage);
        this.column = context.getColumn();
        this.SQLContraint = context.getSqlConstraint();
    }

    public Column getColumn() {
        return this.column;
    }

    public String getSQLContraint() {
        return this.SQLContraint;
    }
}
