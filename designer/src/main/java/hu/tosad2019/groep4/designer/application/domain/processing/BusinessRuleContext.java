package hu.tosad2019.groep4.designer.application.domain.processing;
import java.util.ArrayList;
import java.util.List;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

public class BusinessRuleContext {

    public BusinessRuleContext(BusinessRuleType businessRuleType) {
        // TODO either remove the typesetter or this constructor
        this.businessRuleType = businessRuleType;
        this.specifiedValues = new ArrayList<String>();
    }

    /* PROPERTIES */
    // BusinessRule
    private int id;
    private int is_not;
    private String name;
    private String description;
    private String failure;

    // BusinessRule Type
    private BusinessRuleType businessRuleType;
    private int type_id;

    // BusinessRule Category
    private String category;
    private int category_id;

    // Template
    private String template;
    private int template_id;

    // Statement
    private String statement;
    private int statement_id;

    // Range
    private String range_min_value;
    private String range_max_value;
    private Operator range_min_operator;
    private Operator range_max_operator;

    // List
    private int list_id;

    // Specified Values
    private List<String> business_rule_values;
    private List<String> list_values;



    // DbColumn
    private int dbcolumn_id;

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
    public void setId(int id) { this.id = id; }
    public void setIsNot(int is_not) { this.is_not = is_not; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setFailure(String failure) { this.failure = failure; }

    public void setType(BusinessRuleType type) { this.businessRuleType = type;}
    public void setTypeId(int id) { this.type_id = id; }

    public void setCategory(String category) { this.category = category; }
    public void setCategoryId(int id) { this.category_id = id; }

    public void setTemplate(String value) { this.template = value; }
    public void setTemplateId(int id) { this.template_id = id; }

    public void setStatement(String statement) { this.statement = statement; }
    public void setStatementId(int id) { this.statement_id = id; }

    public void setMinValue(String value) { this.range_min_value = min_value; }
    public void setMaxValue(String value) { this.range_max_value = max_value; }
    public void setMinOperator(String operator) { this.range_min_operator = this.convertStringToOperator(operator); }
    public void setMaxOperator(String operator) { this.range_max_operator = this.convertStringToOperator(operator); }

    public void setListId(int id) { this.list_id = id; }

    public void setBusinessRuleValues(List<String> list) { this.business_rule_values = list; }
    public void setListValues(List<String> list) { this.list_values = list; }






    public void setFirstTable(String table) { this.first_table = table; }
    public void setFirstColumn(String column) { this.first_column = column; }
    public void setOperator(Operator operator) { this.operator = operator; }
    public void addSpecifiedValue(String value) { this.specifiedValues.add(value); }
    public void setSpecifiedValues(List<String> values) { this.specifiedValues = values; }
    public void setSqlQuery(String query) { this.sqlQuery = query; }
    public void setSecondColumn(String column) { this.second_column = column; }
    public void setSecondTable(String table) { this.second_table = table; }


    /* GETTERS */
    public int getId() { return this.id; }
    public int getIsNot() { return this.is_not; }
    public String getName() {
		/*
		 * 	  TODO Rule naming
		 * >> {APP}_            {ENTITY}_{OBJECT}_{RULETYPE}_{ID} : "BRG_PRODUCT_CNS_ACMP_01" 
		 *    {APP}_{TARGETAPP}_{ENTITY}_{OBJECT}_{RULETYPE}_{AUTONUMBER} : "BRG_VBMG_PRT_CNS_TCMP_01" 
		 */
//    	return this.name;
    	return String.format("%s_%s_%s_%s_%s", "TOSADBRG", this.first_table, "CNS", this.businessRuleType.code, this.id);
    }
    public String getDescription() { return this.description; }
    public String getFailure() { return this.failure; }

    public BusinessRuleType getType() { return this.businessRuleType; }
    public int getTypeId() { return this.type_id; }

    public String getCategory() { return this.category; }
    public int getCategoryId() { return this.category_id; }

    public String getTemplate() { return this.template; }
    public int getTemplateId() { return this.template_id; }

    public String getStatement() { return this.statement; }
    public int getStatementId() { return this.statement_id; }

    public String getMinValue() { return this.range_min_value; }
    public String getMaxValue() { return this.range_max_value; }
    public Operator getMinOperator() { return this.range_min_operator; }
    public Operator getMaxOperator() { return this.range_max_operator; }

    public int getListId() { return this.list_id; }
    public String getSQLQuery() { return this.sqlQuery; }

    public List<String> getBusinessRuleValues() { return this.business_rule_values; }
    public List<String> getListValues() { return this.list_values; }

    /* PRIVATE FUNCTIONS */
    private Operator convertStringToOperator(String operatorString) {
        for (Operator operator : Operator.values()) {
            if (operator.label.equals(operatorString)) {
                return operator;
            }
        }
        return null;
    }
    private String convertOperatorToString(Operator operator) {
        return operator.label;
    }

    public Operator getOperator() { return this.operator; }
    public String getFirstTable() { return this.first_table; }
    public String getFirstColumn() { return this.first_column; }
    public String getSecondTable() { return this.second_table; }
    public String getSecondColumn() { return this.second_column; }
    public List<String> getSpecifiedValues() { return this.specifiedValues; }

}