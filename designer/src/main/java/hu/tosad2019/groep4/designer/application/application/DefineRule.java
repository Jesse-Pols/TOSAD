package hu.tosad2019.groep4.designer.application.application;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleFactory;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleService;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefineRule {
    public static boolean saveBusinessRule(BusinessRuleContext context) throws Exception {
        BusinessRuleFactory factory = new BusinessRuleFactory(context);

        return  BusinessRuleService.getInstance().saveBusinessRule(factory.makeBusinessRule());
    }

    public static Map<String, String> getProperties(BusinessRuleType ruleType){

        Map<String, String> properties;

        switch (ruleType){
            case AttributeRangeRule:
                properties = getRangeRuleProperties();
                break;
            case AttributeCompareRule:
                properties = getAttributeCompareRuleProperties();
                break;
            case AttributeListRule:
                properties = getAttributeListRuleProperties();
                break;
            case AttributeOtherRule:
                properties = getAttributeOtherRuleProperties();
                break;
            case TupleCompareRule:
                properties = getTupleCompareRuleProperties();
                break;
            case TupleOtherRule:
                properties = getTupleOtherRuleProperties();
                break;
            case InterEntityCompareRule:
                properties = getInterEntityCompareRuleProperties();
                break;
            case EntityOtherRule:
                properties = getEntityOtherRuleProperties();
                break;
            case ModifyRule:
                properties = getModifyRuleProperties();
                break;
            default:
            	System.err.println("Rule " + ruleType + " does not exists");
                properties = null;
        }


        return properties;
    }



    private static Map<String, String> getRangeRuleProperties(){    	
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Max value", "string");
        properties.put("Min value", "string");


        return properties;
    }

    private static Map<String, String> getAttributeCompareRuleProperties(){
    	Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Value", "string");

        return properties;
    }

    private static Map<String, String> getAttributeListRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Values", "string");

        return properties;
    }

    private static Map<String, String> getAttributeOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQL statement", "stringarea");

        return properties;
    }

    private static Map<String, String> getTupleCompareRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Column 2", "string");

        return properties;
    }

    private static Map<String, String> getTupleOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQL statement", "stringarea");

        return properties;
    }

    private static Map<String, String> getInterEntityCompareRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Operator", "operator");
        properties.put("Table 2", "string");
        properties.put("Column 2", "string");

        return properties;
    }

    private static Map<String, String> getEntityOtherRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("Table 2", "string");
        properties.put("Column 2", "comobox");
        properties.put("SQL statement", "stringarea");

        return properties;
    }

    private static Map<String, String> getModifyRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("Table", "string");
        properties.put("Column", "string");
        properties.put("SQL statement", "stringarea");

        return properties;
    }

}
