package hu.tosad2019.groep4.designer.application.application;

import java.util.LinkedHashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;

public class DefineRule {
    public static boolean saveBusinessRule(BusinessRuleContext context) {
        
    	System.out.println("[DefineRule] TODO: Saving rule of type " + context.getType());
    	
//        BusinessRuleFactory factory = new BusinessRuleFactory(type, properties);
//
//        BusinessRuleService businessRuleService = new BusinessRuleService();
//
//        return  businessRuleService.saveBusinessRule(factory.makeBusinessRule());
		return false;
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

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Max value", "string");
        properties.put("Min value", "string");


        return properties;
    }

    private static Map<String, String> getAttributeCompareRuleProperties(){
    	Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Between", "boolean");
        properties.put("Value", "string");

        return properties;
    }

    private static Map<String, String> getAttributeListRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Values", "string");

        return properties;
    }

    private static Map<String, String> getAttributeOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQL statement", "string");

        return properties;
    }

    private static Map<String, String> getTupleCompareRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column 1", "string");
        properties.put("Operator", "operator");
        properties.put("Column 2", "string");

        return properties;
    }

    private static Map<String, String> getTupleOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

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

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Between", "boolean");
        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "string");
        properties.put("Min. value", "string");
        properties.put("Max. value", "string");

        return properties;
    }

    private static Map<String, String> getEntityOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

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

        properties.put("Name", "string");
        properties.put("Description", "string");

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQL statement", "string");

        return properties;
    }

}
