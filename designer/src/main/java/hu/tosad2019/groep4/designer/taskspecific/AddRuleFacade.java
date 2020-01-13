package hu.tosad2019.groep4.designer.taskspecific;

import java.util.Map;

import javafx.scene.Node;

public class AddRuleFacade {

    public static Map<String, Node> loadUICompoent(String businessRule) {

    	switch(businessRule) {
    		case "Attribute Range Rule":
    			return AddRuleLoader.loadAttributeRangeRule();
    		case "Attribute Compare Rule":
    			return AddRuleLoader.loadAttributeCompareRule();
    		default:
    			System.err.println("Business rule \"" + businessRule + "\" has not been implemented yet.");
    			return null;
    	}
    }
    public static void saveBusinessRule() {
    	// TODO save rule
    }
}
