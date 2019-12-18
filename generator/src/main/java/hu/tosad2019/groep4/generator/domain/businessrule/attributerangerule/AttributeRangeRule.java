package hu.tosad2019.groep4.generator.domain.businessrule.attributerangerule;

import hu.tosad2019.groep4.generator.domain.Enums.Operator;

public class AttributeRangeRule {
	
	private String triggerName;
	private String tableName;	
	private String columnName;
	
	private boolean forEachRow;
	
	private int position;
	private int minValue;
	private int maxValue;
	
	private Operator minValueOperator;
	private Operator maxValueOperator;
	private Operator andOrOperator;
	
	private AttributeRangeRule() { }
	
	public static class Builder {
		private AttributeRangeRule instance;
		public Builder() { instance = new AttributeRangeRule(); }
		
		public Builder setTriggerName(String triggerName) {
			instance.triggerName = triggerName;
			return this;
		}
		
		public Builder setTableName(String tableName) {
			instance.tableName = tableName;
			return this;
		}
		
		public Builder setPosition(int position) {
			instance.position = position;
			return this;
		}
		
		public Builder setforEachRow(boolean forEachRow) {
			instance.forEachRow = forEachRow;
			return this;
		}		
		
		public Builder setColumnName(String columnName) {
			instance.columnName = columnName;
			return this;
		}
		
		public Builder setMinValue(int minValue) {
			instance.minValue = minValue;
			return this;
		}
		
		public Builder setMaxValue(int maxValue) {
			instance.maxValue = maxValue;
			return this;
		}
		
		public Builder setMinValueOperator(Operator operator) {
			instance.minValueOperator = operator;
			return this;
		}
		
		public Builder setMaxValueOperator(Operator operator) {
			instance.maxValueOperator = operator;
			return this;
		}
		
		public Builder setAndOrOperator(Operator operator) {
			instance.andOrOperator = operator;
			return this;
		}
		
		public AttributeRangeRule build() {
			return instance;
		}
	}

}
