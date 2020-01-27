package hu.tosad2019.groep4.designer.presentation.ui;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.application.MainFacade;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleService;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddRuleLoader {

    static Map<String, Node> loadUICompoent(BusinessRuleType ruleType) {

    	Map<String, Node> result = new LinkedHashMap<String, Node>();
    	Map<String, String> properties = MainFacade.getInstance().getProperties(ruleType);

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
				case "operator":
					ComboBox<Operator> combo = new ComboBox<Operator>();
					combo.setStyle("-fx-font: 14px \"monospace\";");
					List<Operator> operators = BusinessRuleService.getInstance().getOperator(ruleType);
					for(Operator t : operators) {
						combo.getItems().add(t);
					}

					result.put(name, combo);
					break;
    			case "stringarea":
    				TextArea ta = new TextArea();
    				ta.setPromptText(name + "..");
    				result.put(name, ta);
    				break;
    		}
    	}
    	
    	return result;
    }
}
