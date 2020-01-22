package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

import java.util.List;

public class BusinessRuleContext {

    public BusinessRuleContext(BusinessRuleType businessRuleType) {
        this.businessRuleType = businessRuleType;
    }

    /* PROPERTIES */
    // BusinessRule
    private String name;
    private String description;
    // BusinessRule Type
    private BusinessRuleType businessRuleType;
    // Range
    private String min_value;
    private String max_value;
    // Operator
    private Operator operator;
    // DbColumn
    private String first_column;
    private String second_column;
    private String first_table;
    private String second_table;
    // Specified Values
    private List<String> specifiedValues;
    // Other
    private String sqlQuery;

    /* SETTERS */
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) { this.description = description; }
    public void setFirstTable(String table) { this.first_table = table; }
    public void setFirstColumn(String column) { this.first_column = column; }
    public void setOperator(Operator operator) { this.operator = operator; }
    public void addSpecifiedValue(String value) { this.specifiedValues.add(value); }
    public void setSpecifiedValues(List<String> values) { this.specifiedValues = values; }
    public void setMinValue(String value) { this.min_value = value; }
    public void setMaxValue(String value) { this.max_value = value; }
    public void setSqlQuery(String query) { this.sqlQuery = sqlQuery; }
    public void setSecondColumn(String column) { this.second_column = column; }
    public void setSecondTable(String table) { this.second_table = table; }

    /* GETTERS */
    public Operator getOperator() {
        return this.operator;
    }
    public BusinessRuleType getType() {
        return this.businessRuleType;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getFirstColumn() {
        return this.first_column;
    }
    public String getFirstTable() {
        return this.first_table;
    }
    public String getMinValue() {
        return this.min_value;
    }
    public String getMaxValue() {
        return this.max_value;
    }
    public List<String> getSpecifiedValues() {
        return this.specifiedValues;
    }
}