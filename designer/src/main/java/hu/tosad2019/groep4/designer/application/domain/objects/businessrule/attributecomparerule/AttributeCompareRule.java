package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule;


import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

public class AttributeCompareRule extends BaseRule {

    private boolean not;
    private Column column;
    private Operator operator;
    private SpecifiedValue value;

    public AttributeCompareRule(String code, String name, String failure, AttributeCompareRuleContext context) {
    	this(code, name, failure, context, 0);
    }
    public AttributeCompareRule(String code, String name, String failure, AttributeCompareRuleContext context, int id){
        super(code, name, failure, id);
        this.not = context.getNot();
        this.column = context.getColumn();
        this.operator = context.getOperator();
        this.value = context.getSpecifiedValue();
    }

    public Column getColumn() {
        return this.column;
    }

    public Operator getOperator(){
        return this.operator;
    }

    public SpecifiedValue getSpecifiedValue(){
        return this.value;
    }

    public boolean getNot(){
        return not;

    }
}
