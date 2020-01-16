package hu.tosad2019.groep4.designer.application;

import java.util.HashMap;
import java.util.Map;

//          application component interface
public class ManageRuleFacade {

    //code, name
    public static HashMap<String, String> getAllBusinessRules(){
        return null;
    }

    public static boolean saveBusinessRule(String type, HashMap<String, String> properties) {
        return DefineRule.saveBusinessRule(type, properties);
    }

    public  Map<String, String> getProperties(String businessRuleType){
        return DefineRule.getProperties(businessRuleType);
    }



}
