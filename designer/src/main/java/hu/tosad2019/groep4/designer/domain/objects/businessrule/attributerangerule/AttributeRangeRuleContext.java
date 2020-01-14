package hu.tosad2019.groep4.designer.domain.objects.businessrule.attributerangerule;

import hu.tosad2019.groep4.designer.domain.objects.Column;
import hu.tosad2019.groep4.designer.domain.objects.Range;

public class AttributeRangeRuleContext {
    private boolean forEachRow;
    private int position;

    private Column column;
    private boolean not;
    private Range range;

    public AttributeRangeRuleContext(boolean forEachRow, int position, Range range) {
        this.forEachRow = forEachRow;
        this.position = position;
        this.range = range;
    }

    public boolean getForEachRow() {
        return forEachRow;
    }

    public int getPosition() {
        return position;
    }

    public Column getColumn() {
        return column;
    }

    public boolean getNot() {
        return not;
    }

    public Range getRange() {
        return range;
    }
}
