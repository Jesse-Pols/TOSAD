package hu.tosad2019.groep4.generator.domain.businessrule.attributerangerule;

import hu.tosad2019.groep4.generator.domain.Column;
import hu.tosad2019.groep4.generator.domain.Range;
import hu.tosad2019.groep4.generator.domain.businessrule.BaseRule;
import hu.tosad2019.groep4.generator.domain.businessrule.BusinessRule;

public class AttributeRangeRule implements BusinessRule {

	private BaseRule rule;

	private Column column;

	private boolean not;

	private boolean forEachRow;

	private Range range;

	private AttributeRangeRule(BaseRule baseRule, AttributeRangeRuleContext context) {
		this.rule = baseRule;
		this.column = context.getColumn();
		this.not = context.getNot();
		this.forEachRow = context.getForEachRow();
		this.range = context.getRange();
	}

	@Override
	public String getCode() {
		return rule.getCode();
	}

	@Override
	public String getName() {
		return rule.getName();
	}

	@Override
	public String getDescription() {
		return rule.getDescription();
	}

}
