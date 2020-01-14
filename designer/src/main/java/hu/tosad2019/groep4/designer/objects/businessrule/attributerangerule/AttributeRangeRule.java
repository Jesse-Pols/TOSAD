package hu.tosad2019.groep4.designer.objects.businessrule.attributerangerule;

import hu.tosad2019.groep4.designer.objects.Column;
import hu.tosad2019.groep4.designer.objects.Range;
import hu.tosad2019.groep4.designer.objects.businessrule.BaseRule;

public class AttributeRangeRule extends BaseRule {

	private Column column;

	private boolean not;

	private boolean forEachRow;

	private Range range;

	public AttributeRangeRule(String code, String name, String description, AttributeRangeRuleContext context) {
		super(code, name, description);
		this.column = context.getColumn();
		this.not = context.getNot();
		this.forEachRow = context.getForEachRow();
		this.range = context.getRange();
	}

}
