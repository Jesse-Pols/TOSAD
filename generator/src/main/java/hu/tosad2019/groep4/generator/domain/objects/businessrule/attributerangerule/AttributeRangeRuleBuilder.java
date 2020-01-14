package hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule;

import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;

public class AttributeRangeRuleBuilder {
	
	private String triggerName;
	private boolean forEachRow;
	private int position;
	
	private String tableName;
	private String columnName;
	private int minValue;
	private int maxValue;
	private Operator minValueOperator;
	private Operator maxValueOperator;
	private Operator andOrOperator;
	
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	
	public void setForEachRow(boolean forEachRow) {
		this.forEachRow = forEachRow;
	}
	
	public void position(int position) {
		this.position = position;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void setColumn(String columnName) {
		this.columnName = columnName;
	}
	
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	public void setMinValueOperator(Operator operator) {
		this.minValueOperator = operator;
	}
	
	public void setMaxValueOperator(Operator operator) {
		this.maxValueOperator = operator;
	}
	
	public void setAndOrOperator(Operator operator) {
		this.andOrOperator = operator;
	}
	
	public _AttributeRangeRule getResult() {
		
		_AttributeRangeRule attributeRangeRule = new _AttributeRangeRule(triggerName, position, forEachRow);
		
		attributeRangeRule.setTable(tableName);
		attributeRangeRule.setColumn(columnName);
		
		attributeRangeRule.setMinValue(minValue);
		attributeRangeRule.setMaxValue(maxValue);
		
		attributeRangeRule.setMinValueOperator(minValueOperator);
		attributeRangeRule.setMaxValueOperator(maxValueOperator);
		attributeRangeRule.setAndOrOperator(andOrOperator);
		
		return attributeRangeRule;
		
	}

}
