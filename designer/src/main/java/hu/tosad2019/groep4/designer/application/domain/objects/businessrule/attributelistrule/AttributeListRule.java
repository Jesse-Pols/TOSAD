package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

import java.util.List;


public class AttributeListRule extends BaseRule {

    private boolean not;
    private Column column;
    private Operator operator;
    private List<SpecifiedValue> list;

    public AttributeListRule(String code, String name, String failure, AttributeListRuleContext context) {
    	this(code, name, failure, context, 0);
    }
    public AttributeListRule(String code, String name, String failure, AttributeListRuleContext context, int id) {
        super(code, name, failure, id);
        this.not = context.getNot();
        this.column = context.getColumn();
        this.operator = context.getOperator();
        this.list = context.getSpecifiedValuelist();
    }

}
