package hu.tosad2019.groep4.designer.application.domain.processing;

import java.util.List;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

public class _BusinessRuleContext {

    // BusinessRule
    private String name;
    private String description;
    private String failure;

    // BusinessRule Type
    private BusinessRuleType type;

    // BusinessRule Category
    private String category_name;

    // DbColumn
    private String first_column;
    private String second_column;
    private String first_table;
    private String second_table;

    // Operator
    private Operator first_operator;
    private Operator second_operator;

    // Range
    private String range_min_value;
    private String range_max_value;
    private Operator min_operator;
    private Operator max_operator;

    // Template
    private String template_value;

    // Specified Value
    private List<String> value;

    // Statement
    private String statement;

    public _BusinessRuleContext(BusinessRuleType type){
    	this.type = type;
    }

    // Getters Type
    public BusinessRuleType getType() {
        return this.type;
    }

    // Getters Business Rule
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String get


	public String getTable() { return table; }
    public String getColumn() {return column; }
    public String getSecondaryTable() { return secondaryTable; }
    public String getSecondaryColumn() { return secondaryColumn; }
	public Operator getOperator() { return operator; }
	public String getSpecifiedValue() { return specifiedValue; }
	public String getSpecifiedValueType() { return specifiedValueType; }
	public String getRange_minValue() { return range_minValue; }
	public String getRange_maxValue() { return range_maxValue; }
	public List<String> getListOfValues() { return listOfValues; }
	public String getSqlQuery() { return sqlQuery; }
	public boolean isRange_between() { return range_between; }

	public void setType(BusinessRuleType type) { this.type = type; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setTable(String table) { this.table = table; }
    public void setColumn(String column) {this.column = column; }
    public void setSecondaryTable(String secondaryTable) { this.secondaryTable = secondaryTable; }
    public void setSecondaryColumn(String secondaryColumn) { this.secondaryColumn = secondaryColumn; }
    public void setOperator(Operator operator) { this.operator = operator; }
    public void setSpecifiedValue(String specifiedValue) { this.specifiedValue = specifiedValue; }
    public void setSpecifiedValueType(String specifiedValueType) { this.specifiedValueType = specifiedValueType;}
    public void setRange_minValue(String range_minValue) { this.range_minValue = range_minValue; }
    public void setRange_maxValue(String range_maxValue) { this.range_maxValue = range_maxValue; }
    public void setListOfValues(List<String> listOfValues) { this.listOfValues = listOfValues; }
    public void setSqlQuery(String sqlQuery) { this.sqlQuery = sqlQuery; }
    public void setRange_between(boolean range_between) { this.range_between = range_between; }

    public String toString() { return "_BusinessRuleContext of type " + this.type; }
}
