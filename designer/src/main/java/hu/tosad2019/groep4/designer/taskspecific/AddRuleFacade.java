package hu.tosad2019.groep4.designer.taskspecific;

import java.util.Map;

import javafx.scene.Node;

public class AddRuleFacade {

    public static Map<String, Node> loadUICompoent(String businessRule) {

    	switch(businessRule) {
    		case "Attribute Range Rule":
    			return AddRuleLoader.loadAttributeRangeRule();
    		case "Attribute compare rule":
    			return AddRuleLoader.loadAttributeCompareRule();
    		default:
    			return null;
    	}
    }
    public static void saveBusinessRule() {
    	// TODO save rule
    }
}
