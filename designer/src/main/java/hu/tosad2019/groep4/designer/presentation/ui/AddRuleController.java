package hu.tosad2019.groep4.designer.presentation.ui;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.application.MainFacade;
import hu.tosad2019.groep4.designer.application.application.ManageRuleFacade;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class AddRuleController {

	@FXML private ComboBox<BusinessRuleType> cb_ruletype;
	@FXML private ComboBox<String> cb_define_table;
	@FXML private ComboBox<String> cb_define_column;
	@FXML private ComboBox<String> cb_define_operator;
	@FXML private VBox vbox_define_selection;
	@FXML private Button btn_save;
	@FXML private TextField messageBox;

	
	// TODO We should place this somewhere else - I agree greetings from Bart - I agree too greetings from Jesse
	private Map<String, Object> currentProperties = new LinkedHashMap<>();
	private List<BusinessRuleType> rules = List.of(BusinessRuleType.values());

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
			lbl.setMinWidth(80);
			lbl.setPadding(new Insets(5,0,0,0));
			Node node = options.get(key);

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

			if (input instanceof TextField) {
				Label propertyNameLabel = (Label) label;
				String propertyName = propertyNameLabel.getText();
				this.currentProperties.put(propertyName, ((TextField) input).getText());

			} else if (input instanceof CheckBox) {
				Label propertyNameLabel = (Label) label;
				String propertyName = propertyNameLabel.getText();
				CheckBox checkbox = (CheckBox) input;
				String isSelected = String.valueOf(checkbox);
				this.currentProperties.put(propertyName, isSelected);
			} else if (input instanceof ComboBox) {
				Label propertyNameLabel = (Label) label;
				String propertyName = propertyNameLabel.getText();
				ComboBox<?> comboBox = (ComboBox<?>) input;
				Object isSelected = comboBox.getSelectionModel().getSelectedItem();
				this.currentProperties.put(propertyName, isSelected);
			}
		}

		if(!(messageBox.getText().isEmpty())) {
			currentProperties.put("failureMessage", messageBox.getText());
		}

		if(this.cb_ruletype.getSelectionModel().getSelectedItem() != null) {
//			manageRuleFacade.saveBusinessRule(cb_ruletype.getSelectionModel().getSelectedItem().replace(" ", ""), currentProperties);
			this.saveRule();
		}
	}
	
	// TODO place this elsewhere?
	private void saveRule() {
		BusinessRuleType type = this.cb_ruletype.getSelectionModel().getSelectedItem();
		System.out.println("Saving " + type.label + "..");
		BusinessRuleContext context = new BusinessRuleContext(type);
		
		context.setName((String) this.currentProperties.get("Name"));
		context.setDescription((String) this.currentProperties.get("Description"));
		context.setTable((String) this.currentProperties.get("Table"));
		context.setColumn((String) this.currentProperties.get("Column"));
		switch(type) {
			case AttributeCompareRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));		
				context.setSpecifiedValue((String) this.currentProperties.get("Value"));
				break;
			case AttributeRangeRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));		
				context.setRange_minValue((String) this.currentProperties.get("Min value"));
				context.setRange_maxValue((String) this.currentProperties.get("Max value"));
				break;
			case AttributeListRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				List<String> values = List.of(((String) this.currentProperties.get("Values")).split(", "));
				context.setListOfValues(values);
				break;
			case AttributeOtherRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				break;
			case TupleCompareRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				context.setSecondaryColumn((String) this.currentProperties.get("Column"));
				break;
			case TupleOtherRule:
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				context.setSecondaryColumn((String) this.currentProperties.get("Column"));
				break;
			case InterEntityCompareRule:
				context.setSecondaryTable((String) this.currentProperties.get("Table 2"));
				context.setSecondaryColumn((String) this.currentProperties.get("Column 2"));
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				break;
			case EntityOtherRule:
				context.setSecondaryTable((String) this.currentProperties.get("Table 2"));
				context.setSecondaryColumn((String) this.currentProperties.get("Column 2"));
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				break;
			case ModifyRule:
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				break;
		}
		MainFacade.saveBusinessRule(context);
	}
	
	private void clearOptions() {
		vbox_define_selection.getChildren().clear();
	}

}