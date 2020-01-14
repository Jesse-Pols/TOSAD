package hu.tosad2019.groep4.designer.presentation;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;

public class AddRuleLoader {

    static Map<String, Node> loadUICompoent(String businessRule) {

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
    
	static Map<String, Node> loadAttributeRangeRule() {
        Map<String, Node> result = new LinkedHashMap<String, Node>();
        
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
        TextField minValue = new TextField();
        minValue.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        minValue.setPromptText("Min value");
        TextField maxValue = new TextField();
        maxValue.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        maxValue.setPromptText("Max value");

        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("minValue", minValue);
        result.put("maxValue", maxValue);
        
        return result;
    }

	static Map<String, Node> loadAttributeCompareRule() {
        Map<String, Node> result = new LinkedHashMap<String, Node>();
                
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select operator..");
        cb3.setPlaceholder(new Label("No operators"));
        // TODO Place this elsewhere, demo data from Drive document
        cb3.getItems().addAll(
        		"[= ] Equal to", 
        		"[!=] Not equal to", 
        		"[> ] Greater than", 
        		"[>=] Greater than or equal", 
        		"[< ] Less than",
        		"[<=] Less than or equal"
        );
        
        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("Operator", cb3);
        
        return result;
    }	
}
