package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.entityotherrule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;

public class EntityOtherRule extends BaseRule {
    private boolean not;
    private Column column1;
    private Column column2;
    private String SQLContraint;

    public EntityOtherRule(String name, String description,Column column1, Column column2, String SQLContraint) {

        super(name, description);
        this.column1 = column1;
        this.column2 = column2;
        this.SQLContraint = SQLContraint;
    }
}
