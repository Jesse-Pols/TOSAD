package hu.tosad2019.groep4.designer.presentation;

import java.util.LinkedHashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.ManageRuleFacade;
import hu.tosad2019.groep4.designer.domain.objects.enums.Operator;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddRuleLoader {

    static Map<String, Node> loadUICompoent(String businessRule) {

    	Map<String, Node> result = new LinkedHashMap<String, Node>();
    	
    	ManageRuleFacade mrf = new ManageRuleFacade();

		System.out.println(businessRule.replace(" ", ""));

    	Map<String, String> properties = mrf.getProperties(businessRule.replace(" ", ""));
    	if(properties == null) {
    		System.err.println("Nothing");
    		return result;
    	}
    	
    	for(String name : properties.keySet()) {
    		String type = properties.get(name);
    		switch(type) {
    			case "string":
    				TextField tf = new TextField();
    				tf.setPromptText(name + "..");
    				result.put(name, tf);
    				break;
    			case "boolean":
					CheckBox cbs = new CheckBox();
					result.put(name, cbs);
					break;
				case "combobox":
					ComboBox combo = new ComboBox();

					for(Operator t : Operator.values()) {
						combo.getItems().add(t.label);
					}

					result.put(name, combo);
					break;
    		}
    	}
    	
    	return result;
    }
}
