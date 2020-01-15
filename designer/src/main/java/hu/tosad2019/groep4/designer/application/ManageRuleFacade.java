package hu.tosad2019.groep4.designer.application;

import java.util.HashMap;

public class ManageRuleFacade {

    public static boolean saveBusinessRule(String type, HashMap<String, String> properties) {
        boolean success = false;

        switch (type){
            default:
                success = false;;
        }

        return success;
    }

    public static boolean updateBusinessRule(String code, HashMap<String, String>properties){
        return false;
    }

    public static HashMap<String, String> getAllBusinessRules(){
        return null;
    }


    public  HashMap<String, String> getProperties(String BusinessRuleType){

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




    private HashMap<String, String> getRangeRuleProperties(){
        HashMap<String, String> properties = new HashMap<String, String>();

        properties.put("", "");


        return properties;
    }

    private HashMap<String, String> getCompareRuleProperties(){
        HashMap<String, String> properties = new HashMap<String, String>();

        properties.put("", "");


        return properties;
    }
}
