package hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributelistrule;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import java.util.List;


public class AttributeListRule extends BaseRule {

    private boolean not;
    private Column column;
    private Operator operator;
    private List<SpecifiedValue> list;

    public AttributeListRule(String code, String name, String failureMessage, AttributeListRuleContext context) {
        super(code, name, failureMessage);
        this.not = context.getNot();
        this.column = context.getColumn();
        this.operator = context.getOperator();
        this.list = context.getSpecifiedValuelist();
    }

}
