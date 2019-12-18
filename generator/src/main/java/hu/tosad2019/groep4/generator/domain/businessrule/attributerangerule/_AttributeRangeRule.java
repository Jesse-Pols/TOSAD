package hu.tosad2019.groep4.generator.domain.businessrule.attributerangerule;

import hu.tosad2019.groep4.generator.domain.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.businessrule.BusinessRule;

public class _AttributeRangeRule implements BusinessRule {
	
	String triggerName;
	String tableName;
	int position;
	boolean forEachRow;
	
	String columnName;
	
	int minValue;
	Operator minValueOperator;	
	Operator andOrOperator;	
	int maxValue;
	Operator maxValueOperator;
	
	private String id;
	private String description;
		
	public _AttributeRangeRule(String triggerName, int position, boolean forEachRow) {
		this.triggerName = triggerName;
		this.position = position;
		this.forEachRow = forEachRow;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setTable(String tableName) {
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
	
	public void setMinValueOperator(Operator minValueOperator) {
		this.minValueOperator = minValueOperator;
	}
	
	public void setAndOrOperator(Operator andOrOperator) {
		this.andOrOperator = andOrOperator;
	}
	
	public void setMaxValueOperator(Operator maxValueOperator) {
		this.maxValueOperator = maxValueOperator;
	}
	
	public String getCode() {
		return this.id;		
	}
	
	public String getName() {
		return this.triggerName;
	}
	
	public String getDescription() {
		return this.description;
	}

}
