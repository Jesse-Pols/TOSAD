package hu.tosad2019.groep4.designer.application;

import java.util.LinkedHashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.storage.objects.domainobjects.IBusinessRule;
import hu.tosad2019.groep4.designer.domain.processing.BusinessRuleFactory;
import hu.tosad2019.groep4.designer.domain.processing.ObjectService;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

public class DefineRule {
    public static boolean saveBusinessRule(String typeString, Map<String, String> properties) {
        BusinessRuleType type = null;
        IBusinessRule rule;


        switch (typeString){
            case "AttributeCompareRule":
                type = BusinessRuleType.AttributeCompareRule;
                break;
            case "AttributeRangeRule":
                type = BusinessRuleType.AttributeRangeRule;
                break;
            default:
                System.err.println("NOT FOUND");
                break;
        }



        BusinessRuleFactory factory = new BusinessRuleFactory(type, properties);
        rule = factory.MakeBusinessRule();

        ObjectService objectService = new ObjectService();

        return  objectService.saveBusinessRule(rule);
    }

    public static Map<String, String> getProperties(String BusinessRuleType){

        Map<String, String> properties;

        switch (BusinessRuleType){
            case "AttributeRangeRule":
                properties = getRangeRuleProperties();
                break;
            case "AttributeCompareRule":
                properties = getCompareRuleProperties();
                break;
            default:
            	System.err.println("Rule " + BusinessRuleType + " not found");
                properties = null;
        }


        return properties;
    }



    private static Map<String, String> getRangeRuleProperties(){
        Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("code", "string");
        properties.put("name", "string");
        properties.put("description", "string");

        properties.put("not", "boolean");
        properties.put("table", "string");
        properties.put("column", "string");
        properties.put("operator", "string");
        properties.put("specifiedvalue", "string");


        return properties;
    }

    private static Map<String, String> getCompareRuleProperties(){
    	Map<String, String> properties = new LinkedHashMap<String, String>();

        properties.put("code", "string");
        properties.put("name", "string");
        properties.put("description", "string");
        properties.put("table", "string");
        properties.put("column", "string");
        properties.put("not", "boolean");
        properties.put("foreachrow", "boolean");
        properties.put("minvalue", "string");
        properties.put("maxvalue", "string");
        properties.put("minvalueOperator", "string");
        properties.put("maxvalueOperator", "string");



        return properties;
    }
}
