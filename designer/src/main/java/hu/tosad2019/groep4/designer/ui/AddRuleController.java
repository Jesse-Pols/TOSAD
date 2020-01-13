package hu.tosad2019.groep4.designer.ui;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;

public class AddRuleController {

	@FXML private ComboBox<String> cb_ruletype;
	@FXML private ComboBox<String> cb_define_table;
	@FXML private ComboBox<String> cb_define_column;
	@FXML private ComboBox<String> cb_define_operator;
	@FXML private TitledPane tp_validation;
	
	// TODO We should place this somewhere else
	private List<String> rules = Arrays.asList("Attribute Range Rule", "Attribute compare rule", "Attribute list rule", "Attribute Other Rule", "Tuple Compare Rule", "Tuple Other Rule", "Inter-Entity Compare rule", "Entity Other Rule", "Modify Rule");
	
	@FXML private void initialize() {
		cb_ruletype.getItems().addAll(this.rules);
	}
	
	@FXML 
	private void btn_home_add_onclick() {
		
	}
}
