package hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributelistrule;

import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;

import java.util.List;

public class AttributeListRuleContext {


    private Column column;
    private boolean not;
    private Operator operator;
    private List<SpecifiedValue> specifiedValuelist;


    public Column getColumn() {
        return column;
    }

    public boolean getNot() {
        return not;
    }

    public Operator getOperator() {
        return operator;
    }

    public List<SpecifiedValue> getSpecifiedValuelist() {
        return this.specifiedValuelist;
    }

    public AttributeListRuleContext(Column column, boolean not, Operator operator, List<SpecifiedValue> specifiedValuelist) {
        this.column = column;
        this.not = not;
        this.operator = operator;
        this.specifiedValuelist = specifiedValuelist;
    }



}
