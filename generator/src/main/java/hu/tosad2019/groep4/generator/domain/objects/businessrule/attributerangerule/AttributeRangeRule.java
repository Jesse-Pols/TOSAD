package hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule;

import hu.tosad2019.groep4.generator.domain.objects.Column;
import hu.tosad2019.groep4.generator.domain.objects.Range;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;

public class AttributeRangeRule extends BaseRule{

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
