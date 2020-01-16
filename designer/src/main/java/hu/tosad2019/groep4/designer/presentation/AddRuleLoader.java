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
    		case "Attribute List Rule":
    			return AddRuleLoader.loadAttributeListRule();
    		case "Attribute Other Rule":
    			return AddRuleLoader.loadAttributeOtherRule();
    		case "Tuple Compare Rule":
    			return AddRuleLoader.loadTupleCompareRule();
    		case "Tuple Other Rule":
    			return AddRuleLoader.loadTupleOtherRule();
    		case "Inter-Entity Compare rule":
    			return AddRuleLoader.loadInterEntityCompareRule();
    		case "Entity Other Rule":
    			return AddRuleLoader.loadEntityOtherRule();
    		case "Modify Rule":
    			return AddRuleLoader.loadModifyRule();
    		default:
    			System.err.println("Business rule \"" + businessRule + "\" has not been implemented yet.");
    			return null;
    	}
    }
    
	static Map<String, Node> loadAttributeRangeRule() {
        Map<String, Node> result = new LinkedHashMap<String, Node>();
        
//      Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
//      Operator
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select operator..");
        cb3.setPlaceholder(new Label("No operators"));
        cb3.getItems().addAll(
        		"[><] Between", 
        		"[<>] Not between" 
        );
//      Min
        TextField minValue = new TextField();
        minValue.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        minValue.setPromptText("Min value");
//      Max
        TextField maxValue = new TextField();
        maxValue.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        maxValue.setPromptText("Max value");

        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("Operator", cb3);
        result.put("MinValue", minValue);
        result.put("MaxValue", maxValue);
        
        return result;
    }
	static Map<String, Node> loadAttributeCompareRule() {
        Map<String, Node> result = new LinkedHashMap<String, Node>();
                
//      Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
//      Operator
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select operator..");
        cb3.setPlaceholder(new Label("No operators"));
        cb3.getItems().addAll(
        		"[= ] Equal to", 
        		"[!=] Not equal to", 
        		"[> ] Greater than", 
        		"[>=] Greater than or equal", 
        		"[< ] Less than",
        		"[<=] Less than or equal"
        );
//      Value
        TextField value = new TextField();
        value.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        value.setPromptText("Value");
        
        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("Operator", cb3);
        result.put("Value", value);
        
        return result;
    }
	static Map<String, Node> loadAttributeListRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();
		
//		Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
//      Operator
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select operator..");
        cb3.setPlaceholder(new Label("No operators"));
        // TODO Place this elsewhere, demo data from Drive document
        cb3.getItems().addAll(
        		"[= ] Equal to", 
        		"[!=] Not equal to"
        );
        
//      TextField 1
        TextField value1 = new TextField();
//        value1.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        value1.setPromptText("Value");
//      TextField 2
        TextField value2 = new TextField();
//        value2.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        value2.setPromptText("Value");
//      TextField 3
        TextField value3 = new TextField();
//        value3.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        value3.setPromptText("Value");
        
        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("Operator", cb3);
        result.put("Value", value1);
        result.put("Value", value2);
        result.put("Value", value3);
        
		return result;
	}
	static Map<String, Node> loadAttributeOtherRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();

//		Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
//      Value
        TextArea sqlstatement = new TextArea();
        sqlstatement.setPromptText("Value");
        
        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("SQLStatement", sqlstatement);
		
		return result;
	}
	static Map<String, Node> loadTupleCompareRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();
		
//		Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column 1
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column 1..");
        cb2.setPlaceholder(new Label("No columns"));
//      Column 2
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select column 2..");
        cb3.setPlaceholder(new Label("No columns"));
//      Operator
        ComboBox<String> cb4 = new ComboBox<String>();
        cb4.setPromptText("Select operator..");
        cb4.setPlaceholder(new Label("No operators"));
        cb4.getItems().addAll(
        		"[= ] Equal to", 
        		"[!=] Not equal to", 
        		"[> ] Greater than", 
        		"[>=] Greater than or equal", 
        		"[< ] Less than",
        		"[<=] Less than or equal"
        );
        
        result.put("Table", cb1);
        result.put("Column1", cb2);
        result.put("Column2", cb3);
        result.put("Operator", cb4);
		
		return result;
	}
	static Map<String, Node> loadTupleOtherRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();
		
//		Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column 1
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column 1..");
        cb2.setPlaceholder(new Label("No columns"));
//      Column 2
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select column 2..");
        cb3.setPlaceholder(new Label("No columns"));
//      Value
        TextArea sqlstatement = new TextArea();
        sqlstatement.setPromptText("Value");
        
        result.put("Table", cb1);
        result.put("Column1", cb2);
        result.put("Column2", cb3);
        result.put("SQLStatement", sqlstatement);
        
		return result;
	}
	static Map<String, Node> loadInterEntityCompareRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();
		
//      Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table 1..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column 1..");
        cb2.setPlaceholder(new Label("No columns"));
//      Table
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select table 2..");
        cb3.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb4 = new ComboBox<String>();
        cb4.setPromptText("Select column 2..");
        cb4.setPlaceholder(new Label("No columns"));
//      Operator
        ComboBox<String> cb5 = new ComboBox<String>();
        cb5.setPromptText("Select operator..");
        cb5.setPlaceholder(new Label("No operators"));
        cb5.getItems().addAll(
        		"[= ] Equal to", 
        		"[!=] Not equal to", 
        		"[> ] Greater than", 
        		"[>=] Greater than or equal", 
        		"[< ] Less than",
        		"[<=] Less than or equal"
        );
        
        result.put("Table1", cb1);
        result.put("Column1", cb2);
        result.put("Table2", cb3);
        result.put("Column2", cb4);
        result.put("Operator", cb5);
        
		return result;
	}
	static Map<String, Node> loadEntityOtherRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();
		
//      Table 1
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table 1..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column 1
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column 1..");
        cb2.setPlaceholder(new Label("No columns"));
//      Table 2
        ComboBox<String> cb3 = new ComboBox<String>();
        cb3.setPromptText("Select table 2..");
        cb3.setPlaceholder(new Label("No tables"));
//      Column 2
        ComboBox<String> cb4 = new ComboBox<String>();
        cb4.setPromptText("Select column 2..");
        cb4.setPlaceholder(new Label("No columns"));
//      Value
        TextArea sqlstatement = new TextArea();
        sqlstatement.setPromptText("Value");
        
        result.put("Table1", cb1);
        result.put("Column1", cb2);
        result.put("Table2", cb3);
        result.put("Column2", cb4);
        result.put("SQLStatement", sqlstatement);
		
		return result;
	}
	static Map<String, Node> loadModifyRule(){
		Map<String, Node> result = new LinkedHashMap<String, Node>();
		
//		Table
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.setPlaceholder(new Label("No tables"));
//      Column
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.setPlaceholder(new Label("No columns"));
//      Value
        TextArea sqlstatement = new TextArea();
        sqlstatement.setPromptText("Value");
        
        result.put("Table", cb1);
        result.put("Column", cb2);
        result.put("SQLStatement", sqlstatement);
        
		return result;
	}
}
