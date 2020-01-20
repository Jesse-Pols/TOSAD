package hu.tosad2019.groep4.generator.domain.objects.processed.businessrule.attributerangerule;

import hu.tosad2019.groep4.generator.domain.objects.processed.Column;
import hu.tosad2019.groep4.generator.domain.objects.processed.Range;

public class AttributeRangeRuleContext {
    private boolean forEachRow;
    private Column column;
    private boolean not;
    private Range range;

    public AttributeRangeRuleContext(boolean forEachRow, boolean not, Column column, Range range) {
        this.forEachRow = forEachRow;
        this.not = not;
        this.column = column;
        this.range = range;
    }

    public boolean getForEachRow() {
        return forEachRow;
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
