package hu.tosad2019.groep4.designer.application.application;

import java.util.HashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.domain.processing._BusinessRuleContext;

//          application component interface
public class ManageRuleFacade {

    //code, name
    public static HashMap<String, String> getAllBusinessRules(){
        return null;
    }

    public static boolean saveBusinessRule(_BusinessRuleContext context) {
        return DefineRule.saveBusinessRule(context);
    }

    public  Map<String, String> getProperties(String businessRuleType){
        return DefineRule.getProperties(businessRuleType);
    }

}
