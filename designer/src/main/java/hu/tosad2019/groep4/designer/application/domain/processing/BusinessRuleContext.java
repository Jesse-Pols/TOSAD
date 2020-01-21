package hu.tosad2019.groep4.designer.application.domain.processing;

import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

import java.util.List;

public class BusinessRuleContext {

    private BusinessRuleType type;
    private String name;
    private String description;
    private String table;
    private Operator operator;
    private String specifiedValue;
    private String specifiedValueType;
    private String range_minValue;
    private String range_maxValue;
    private List<String> listOfValues;
    private String sqlQuery;
    boolean range_between;

    public void setType(BusinessRuleType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setSpecifiedValue(String specifiedValue) {
        this.specifiedValue = specifiedValue;
    }

    public void setSpecifiedValueType(String specifiedValueType) {
        this.specifiedValueType = specifiedValueType;
    }

    public void setRange_minValue(String range_minValue) {
        this.range_minValue = range_minValue;
    }

    public void setRange_maxValue(String range_maxValue) {
        this.range_maxValue = range_maxValue;
    }

    public void setListOfValues(List<String> listOfValues) {
        this.listOfValues = listOfValues;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public void setRange_between(boolean range_between) {
        this.range_between = range_between;
    }

    BusinessRuleContext(BusinessRuleType type){

    }


}
