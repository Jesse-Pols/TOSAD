package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributeotherrule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;

public class AttributeOtherRule extends BaseRule {
    private boolean not;
    private Column column;
    private String SQLContraint;



    public AttributeOtherRule(String name, String description, Column column, String SQLContraint) {
        super(name, description);
        this.column = column;
        this.SQLContraint = SQLContraint;
    }
}
