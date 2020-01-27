package hu.tosad2019.groep4.designer.presentation.ui;

import hu.tosad2019.groep4.designer.application.application.MainFacade;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddRuleController {

	@FXML private ComboBox<BusinessRuleType> cb_ruletype;
	@FXML private ComboBox<String> cb_define_table;
	@FXML private ComboBox<String> cb_define_column;
	@FXML private ComboBox<String> cb_define_operator;
	@FXML private VBox vbox_define_selection;
	@FXML private Button btn_save;
	@FXML private TextField messageBox;
	@FXML private Label alert_message;


	private Map<String, Object> currentProperties = new LinkedHashMap<>();
	private List<BusinessRuleType> rules = List.of(BusinessRuleType.values());

	@FXML private void initialize() {
		cb_ruletype.getItems().addAll(this.rules);
		this.clearOptions();
		this.alert_message.setTextFill(Color.web("#212121"));
	}

	@FXML
	private void cb_ruletype_onselect() {
		this.clearOptions();
		BusinessRuleType selectedType= cb_ruletype.getSelectionModel().getSelectedItem();
		Map<String, Node> options = AddRuleLoader.loadUICompoent(selectedType);

		if(options == null) {
			return;
		}

		for(String key : options.keySet()) {
			Label lbl = new Label(key);
			lbl.setMinWidth(80);
			lbl.setPadding(new Insets(5,0,0,0));
			lbl.setTextFill(Color.web("#e1e1e1"));
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
		context.setFirstTable((String) this.currentProperties.get("Table"));
		context.setFirstColumn((String) this.currentProperties.get("Column"));
		switch(type) {
			case AttributeCompareRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));		
				context.addSpecifiedValue((String) this.currentProperties.get("Value"));
				break;
			case AttributeRangeRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));		
				context.setMinValue((String) this.currentProperties.get("Min value"));
				context.setMaxValue((String) this.currentProperties.get("Max value"));
				break;
			case AttributeListRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				List<String> values = List.of(((String) this.currentProperties.get("Values")).split(", "));
				context.setSpecifiedValues(values);
				break;
			case AttributeOtherRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				break;
			case TupleCompareRule:
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				context.setSecondColumn((String) this.currentProperties.get("Column"));
				break;
			case TupleOtherRule:
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				context.setSecondColumn((String) this.currentProperties.get("Column"));
				break;
			case InterEntityCompareRule:
				context.setSecondColumn((String) this.currentProperties.get("Table 2"));
				context.setSecondColumn((String) this.currentProperties.get("Column 2"));
				context.setOperator((Operator) this.currentProperties.get("Operator"));
				break;
			case EntityOtherRule:
				context.setSecondTable((String) this.currentProperties.get("Table 2"));
				context.setSecondColumn((String) this.currentProperties.get("Column 2"));
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				break;
			case ModifyRule:
				context.setSqlQuery((String) this.currentProperties.get("SQL statement"));
				break;
		}
//		MainFacade.saveBusinessRule(context);
		MainFacade.getInstance().saveBusinessRule(context);
	}
	
	private void clearOptions() { vbox_define_selection.getChildren().clear(); }

	public void setAlertMessage(String message, String kindOfMessage) {
		if(kindOfMessage.equals("Succes")) {
			this.alert_message.setTextFill(Color.web("#68B21E"));
			this.alert_message.setText(message);
		}

		if(kindOfMessage.equals("Failure")) {
			this.alert_message.setTextFill(Color.web("#FF0000"));
			this.alert_message.setText(message);
		}
	}

	public void hideAlertMessage() { this.alert_message.setTextFill(Color.web("#212121")); }

}
