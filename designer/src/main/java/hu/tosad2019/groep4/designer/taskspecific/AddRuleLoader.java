package hu.tosad2019.groep4.designer.taskspecific;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AddRuleLoader {

	static Map<String, Node> loadAttributeRangeRule() {
        Map<String, Node> result = new LinkedHashMap<String, Node>();
        
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPromptText("Select table..");
        cb1.prefWidth(200);
        ComboBox<String> cb2 = new ComboBox<String>();
        cb2.setPromptText("Select column..");
        cb2.prefWidth(200);
        
        result.put("Table", cb1);
        result.put("Column", cb2);
        
        return result;
    }

	static Map<String, Node> loadAttributeCompareRule() {
        Map<String, Node> result = new LinkedHashMap<String, Node>();
        
        ComboBox<String> cb1 = new ComboBox<String>();
        cb1.setPlaceholder(new Label("Select table.."));
  
        result.put("Table", cb1);
        
        return result;
//        clearCanvas(hbox, vbox);
//
//        ComboBox<String> columList = createComboBox();
//        columList.setPlaceholder(new Label("Select column..."));
//        columList.getItems().add("Column1");
//
//        ComboBox<String> tableList = createComboBox();
//        tableList.setPlaceholder(new Label("Select table..."));
//        tableList.getItems().add("table1");
//
//        ComboBox<String> operatorList = createComboBox();
//        operatorList.setPlaceholder(new Label("Select operator..."));
//        operatorList.getItems().add("Equal");
//
//        HBox comboHbox = createHbox();
//        comboHbox.getChildren().add(columList);
//        comboHbox.setMaxWidth(Double.MAX_VALUE);
//        HBox.setHgrow(columList, Priority.ALWAYS);
//
//        HBox tableListHBox = createHbox();
//        tableListHBox.getChildren().add(tableList);
//
//        HBox operatorListHbox = createHbox();
//        operatorListHbox.getChildren().add(operatorList);
//
////        hbox.getChildren().add(columList);
////        hbox.getChildren().add(tableList);
////        hbox.getChildren().add(operatorList);
//
//        vbox.getChildren().add(comboHbox);
//        vbox.getChildren().add(tableListHBox);
//        vbox.getChildren().add(operatorListHbox);
    }	
}
