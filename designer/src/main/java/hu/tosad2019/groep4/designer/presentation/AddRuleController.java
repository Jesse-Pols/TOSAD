package hu.tosad2019.groep4.designer.presentation;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddRuleController {

	@FXML private ComboBox<String> cb_ruletype;
	@FXML private ComboBox<String> cb_define_table;
	@FXML private ComboBox<String> cb_define_column;
	@FXML private ComboBox<String> cb_define_operator;
	@FXML private VBox vbox_define_selection;
	@FXML private TitledPane tp_validation;
	@FXML private HBox hbox_define_selection;

	
	// TODO We should place this somewhere else
	private List<String> rules = Arrays.asList("Attribute Range Rule", "Attribute compare rule", "Attribute list rule", "Attribute Other Rule", "Tuple Compare Rule", "Tuple Other Rule", "Inter-Entity Compare rule", "Entity Other Rule", "Modify Rule");
	private LoadUIDynamicallyFacade loadUIDynamicallyFacade;


	@FXML private void initialize() {
		cb_ruletype.getItems().addAll(this.rules);
		vbox_define_selection.getChildren().clear();
		loadUIDynamicallyFacade = new LoadUIDynamicallyFacade();
	}

	@FXML
	private void cb_ruletype_onselect() {

		loadUIDynamicallyFacade.loadUICompoent(cb_ruletype.getSelectionModel().getSelectedItem().toString(), vbox_define_selection, hbox_define_selection);



	}



	@FXML
	private void generateRule() {

		System.out.println(cb_ruletype.getSelectionModel().getSelectedItem().toString());
		System.out.println(cb_define_column.getSelectionModel().getSelectedItem().toString());
		System.out.println(cb_define_operator.getSelectionModel().getSelectedItem().toString());
		System.out.println(cb_define_table.getSelectionModel().getSelectedItem().toString());

	}




}
