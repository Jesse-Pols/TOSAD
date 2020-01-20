package hu.tosad2019.groep4.designer.presentation;

import java.util.*;

import hu.tosad2019.groep4.designer.application.ManageRuleFacade;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.hibernate.annotations.Check;
import org.w3c.dom.Text;

public class AddRuleController {

	@FXML private ComboBox<String> cb_ruletype;
	@FXML private ComboBox<String> cb_define_table;
	@FXML private ComboBox<String> cb_define_column;
	@FXML private ComboBox<String> cb_define_operator;
	@FXML private VBox vbox_define_selection;
	@FXML private Button btn_save;

	
	// TODO We should place this somewhere else - I agree greetings from Bart - I agree too greetings from Jesse
	private List<String> rules = Arrays.asList("Attribute Range Rule", "Attribute Compare Rule", "Attribute List Rule", "Attribute Other Rule", "Tuple Compare Rule", "Tuple Other Rule", "Inter-Entity Compare rule", "Entity Other Rule", "Modify Rule");
	private Map<String, String> currentProperties = new LinkedHashMap<>();
	private ManageRuleFacade manageRuleFacade = new ManageRuleFacade();


	@FXML private void initialize() {
		cb_ruletype.getItems().addAll(this.rules);
		this.clearOptions();
	}

	@FXML
	private void cb_ruletype_onselect() {
		this.clearOptions();
		String rulename = cb_ruletype.getSelectionModel().getSelectedItem().toString();
		Map<String, Node> options = AddRuleLoader.loadUICompoent(rulename);

		if(options == null) {
			return;
		}

		for(String key : options.keySet()) {
			Label lbl = new Label(key);
			lbl.setMinWidth(70);
			lbl.setPadding(new Insets(5,0,0,0));
			Node node = options.get(key);

			System.out.println(options.get(key));

			HBox box = new HBox();
			box.setSpacing(10);
			box.getChildren().addAll(lbl, node);
			HBox.setHgrow(node, Priority.ALWAYS);
			vbox_define_selection.getChildren().add(box);
		}
	}

	@FXML private void btn_save_onclick() {

		for (Node node : vbox_define_selection.getChildren()) {

			if (!(node instanceof HBox)) continue;

			HBox hbox = (HBox) node;

			Node input = hbox.getChildren().get(1);
			Node label = hbox.getChildren().get(0);
			System.out.println(input);
			if (input instanceof TextField) {

				Label propertyNameLabel = (Label) label;
				String propertyName = propertyNameLabel.getText();

				this.currentProperties.put(propertyName, ((TextField) input).getText());
				System.out.println("saved data");

			} else if (input instanceof CheckBox) {
				Label propertyNameLabel = (Label) label;
				String propertyName = propertyNameLabel.getText();

				CheckBox checkbox = (CheckBox) input;
				String isSelected = String.valueOf(checkbox);

				this.currentProperties.put(propertyName, isSelected);
				System.out.println("saved data");
			}

			System.out.println(this.currentProperties.size());
			System.out.println("SAVE");
		}

		if(!(currentProperties.isEmpty())) {
			manageRuleFacade.saveBusinessRule(cb_ruletype.getSelectionModel().getSelectedItem().replace(" ", ""), currentProperties);
		}
	}
	
	private void clearOptions() {
		vbox_define_selection.getChildren().clear();
	}

}
