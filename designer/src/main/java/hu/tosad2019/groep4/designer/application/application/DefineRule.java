package hu.tosad2019.groep4.designer.application.application;

import java.util.LinkedHashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleFactory;
import hu.tosad2019.groep4.designer.application.domain.processing.ObjectService;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

public class DefineRule {
    public static boolean saveBusinessRule(String typeString, Map<String, String> properties) {
        BusinessRuleType type = null;

        switch (typeString){
            case "AttributeCompareRule":
                type = BusinessRuleType.AttributeCompareRule;
                break;
            case "AttributeRangeRule":
                type = BusinessRuleType.AttributeRangeRule;
                break;
            case "AttributeListRules":
                type = BusinessRuleType.AttributeListRule;
                break;
            case "AttributeOtherRule":
                type = BusinessRuleType.AttributeOtherRule;
                break;
            case "TupleCompareRule":
                type = BusinessRuleType.TupleCompareRule;
                break;
            case "TupleOtherRule":
                type = BusinessRuleType.TupleOtherRule;
                break;
            case "Inter-EntityComparerule":
                type = BusinessRuleType.InterEntityCompareRule;
                break;
            case "EntityOtherRule":
                type = BusinessRuleType.EntityOtherRule;
                break;
            case "ModifyRule":
                type = BusinessRuleType.ModifyRule;
                break;
            default:
                System.err.println("NOT FOUND");
                break;
        }



        BusinessRuleFactory factory = new BusinessRuleFactory(type, properties);

        ObjectService objectService = new ObjectService();

        return  objectService.saveBusinessRule();
    }

    public static Map<String, String> getProperties(String BusinessRuleType){

        Map<String, String> properties;

        switch (BusinessRuleType){
            case "AttributeRangeRule":
                properties = getRangeRuleProperties();
                break;
            case "AttributeCompareRule":
                properties = getAttributeCompareRuleProperties();
                break;
            case "AttributeListRule":
                properties = getAttributeListRuleProperties();
                break;
            case "AttributeOtherRule":
                properties = getAttributeOtherRuleProperties();
                break;
            case "TupleCompareRule":
                properties = getTupleCompareRuleProperties();
                break;
            case "TupleOtherRule":
                properties = getTupleOtherRuleProperties();
                break;
            case "Inter-EntityComparerule":
                properties = getInterEntityCompareRuleProperties();
                break;
            case "EntityOtherRule":
                properties = getEntityOtherRuleProperties();
                break;
            case "ModifyRule":
                properties = getModifyRuleProperties();
                break;
            default:
            	System.err.println("Rule " + BusinessRuleType + " not found");
                properties = null;
        }


        return properties;
    }



    private static Map<String, String> getRangeRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Specified value", "string");


        return properties;
    }

    private static Map<String, String> getAttributeCompareRuleProperties(){
    	Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Between", "boolean");
        properties.put("For each row", "boolean");
        properties.put("Min. value", "string");
        properties.put("Max. value", "string");

        return properties;
    }

    private static Map<String, String> getAttributeListRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Value", "string");

        return properties;
    }

    private static Map<String, String> getAttributeOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQl statement", "string");

        return properties;
    }

    private static Map<String, String> getTupleCompareRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("For each row", "boolean");
        properties.put("Min. value", "string");
        properties.put("Max. value", "string");

        return properties;
    }

    private static Map<String, String> getTupleOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "string");
        properties.put("Column", "string");

        return properties;
    }

    private static Map<String, String> getInterEntityCompareRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Between", "boolean");
        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "string");
        properties.put("For each row", "boolean");
        properties.put("Min. value", "string");
        properties.put("Max. value", "string");

        return properties;
    }

    private static Map<String, String> getEntityOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "string");
        properties.put("Column", "comobox");
        properties.put("SQL statement", "string");

        return properties;
    }

    private static Map<String, String> getModifyRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Code", "string");
        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQL statement", "string");

        return properties;
    }

}
