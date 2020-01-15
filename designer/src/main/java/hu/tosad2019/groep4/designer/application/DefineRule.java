package hu.tosad2019.groep4.designer.application;

import hu.tosad2019.groep4.designer.dataaccess.objects.domainobjects.IBusinessRule;
import hu.tosad2019.groep4.designer.domain.processing.BusinessRuleFactory;
import hu.tosad2019.groep4.designer.domain.processing.ObjectService;
import hu.tosad2019.groep4.designer.domain.processing.enums.BusinessRuleType;

import java.util.HashMap;

public class DefineRule {
    public static boolean saveBusinessRule(String typeString, HashMap<String, String> properties) {
        boolean success = false;
        BusinessRuleType type = null;
        IBusinessRule rule = null;




        switch (typeString){
            case "AttributeCompareRule":
                type = BusinessRuleType.AttributeCompareRule;
                break;
            case "AttributeRangeRule":
                type = BusinessRuleType.AttributeRangeRule;
                break;
            default:
                break;
        }



        BusinessRuleFactory factory = new BusinessRuleFactory(type, properties);
        rule = factory.MakeBusinessRule();

        ObjectService objectService = new ObjectService();

        return  objectService.saveBusinessRule(rule);
    }

    public static HashMap<String, String> getProperties(String BusinessRuleType){

        HashMap<String, String> properties = new HashMap<>();

        switch (BusinessRuleType){
            case "AttributeRangeRule":
                properties = getRangeRuleProperties();
                break;
            case "AttributeCompareRule":
                properties = getCompareRuleProperties();
                break;
            default:
                properties = null;
        }


        return properties;
    }



    private static HashMap<String, String> getRangeRuleProperties(){
        HashMap<String, String> properties = new HashMap<String, String>();

        properties.put("", "");


        return properties;
    }

    private static HashMap<String, String> getCompareRuleProperties(){
        HashMap<String, String> properties = new HashMap<String, String>();

        properties.put("", "");


        return properties;
    }
}
