package hu.tosad2019.groep4.designer.presentation;

import java.util.LinkedHashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.ManageRuleFacade;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AddRuleLoader {

    static Map<String, Node> loadUICompoent(String businessRule) {
    	Map<String, Node> result = new LinkedHashMap<String, Node>();
    	
    	ManageRuleFacade mrf = new ManageRuleFacade();
    	Map<String, String> properties = mrf.getProperties(businessRule.replace(" ", ""));
    	if(properties == null) {
    		System.err.println("Nothing");
    		return result;
    	}
    	
    	for(String name : properties.keySet()) {
    		String type = properties.get(name);
    		switch(type) {
    			case "string":
    				ComboBox<String> cb = new ComboBox<String>();
    		        cb.setPromptText(name + "..");
    		        cb.setPlaceholder(new Label("Empty"));
    				result.put(name, cb);
    				break;
    			case "boolean":
    				CheckBox cbs = new CheckBox();
    				result.put(name, cbs);
    				break;
    		}
    	}
    	
    	return result;
    }
}
