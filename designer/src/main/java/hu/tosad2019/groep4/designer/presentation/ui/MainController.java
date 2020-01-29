package hu.tosad2019.groep4.designer.presentation.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hu.tosad2019.groep4.designer.application.application.MainFacade;
import hu.tosad2019.groep4.designer.application.application.TargetDbContext;
import hu.tosad2019.groep4.designer.application.application.TargetDbController;
import hu.tosad2019.groep4.designer.application.domain.objects.Column;
import hu.tosad2019.groep4.designer.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.designer.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class MainController {

	// Home
	@FXML private TableView<BusinessRule> tbl_businessrules;
	@FXML private Button btn_home_add;

	// Generate
	@FXML private Label lbl_generate_dbstatus;
	@FXML private Label tdb_generateStatus;
	@FXML private ComboBox<String> cb_generate_protocol;
	@FXML private TextField txt_generate_host;
	@FXML private TextField txt_generate_port;
	@FXML private Button btn_generate_connect;
	@FXML private Label error_message;

	// Target db connection
	@FXML private TextField txt_targetdb_host;
	@FXML private TextField txt_targetdb_port;
	@FXML private TextField txt_targetdb_username;
	@FXML private TextField txt_targetdb_password;
	@FXML private TextField searchTextField;
	@FXML private ComboBox<String> cb_targetdb_type;
	@FXML private Button button_targetdb_connect;
	@FXML private Button btn_home_refresh;

	private ObservableList<BusinessRule> rules;

	private TargetDbContext targetDbContext;

	@FXML private void initialize() {

		//Generator server connection
		cb_generate_protocol.getItems().addAll("http://", "https://");
		cb_generate_protocol.getSelectionModel().selectFirst();
		tbl_businessrules.setPlaceholder(new Label("No business rules defined"));

		//Target database server connection
		cb_targetdb_type.getItems().addAll("Oracle");
		cb_targetdb_type.getSelectionModel().select(0);
		

		this.rules = FXCollections.observableArrayList();
		try {
			this.refreshRules();
		}catch(Exception e) {
			System.err.println("Could not load rules");
		}
		
		this.setupTable();
		this.setupContextMenu();
	}

	@FXML
	private void btn_home_add_onclick() {
		WindowManager.getInstance().openAddRuleWindow();
	}
	
	@FXML
	private void btn_home_refresh_onclick() {
		this.refreshRules();
		this.sendSuccess("Refreshed rules");
	}
	
	private void refreshRules() {
		this.rules.setAll(getBusinessrules());
	}

	private void setupTable() {
		TableColumn<BusinessRule, String> column_name = new TableColumn<>("Name");

		column_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessRule, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BusinessRule, String> p) {
				BusinessRule name = p.getValue();
				return new SimpleStringProperty(name!=null?name.getName():"Unnamed");
			}
		});

		TableColumn<BusinessRule, String> column_type = new TableColumn<>("Type");
		column_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessRule, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<BusinessRule, String> p) {
				BusinessRule name = p.getValue();
				return new SimpleStringProperty(name!=null?name.getCode():"No Type");
			}
		});
//        this.tbl_businessrules.getColumns().add(column_name);
		this.tbl_businessrules.getColumns().add(column_name);
		this.tbl_businessrules.getColumns().add(column_type);

		this.tbl_businessrules.setItems(this.rules);
	}

	private void setupContextMenu() {
		// Create ContextMenu
		ContextMenu contextMenu = new ContextMenu();

		MenuItem item1 = new MenuItem("Remove");
		item1.setOnAction(new EventHandler < ActionEvent > () {

			@Override
			public void handle(ActionEvent event) {
				if(sendConfimation("Remove rule", "Are you sure you want to remove rule ..?")) {
					rules.remove(tbl_businessrules.getSelectionModel().getSelectedItem());

					try {
						BusinessRuleService.getInstance().deleteBusinessRule(tbl_businessrules.getSelectionModel().getSelectedItem());
					} catch(Exception e) {
						e.printStackTrace();
					}
				}

			}
		});
		MenuItem item2 = new MenuItem("Generate");
		item2.setOnAction(new EventHandler < ActionEvent > () {

			@Override
			public void handle(ActionEvent event) {
				int id = tbl_businessrules.getSelectionModel().getSelectedItem().id();
				try {
					generateBusinessRule(id);
				} catch (Exception e) {
					sendError(e.getMessage());
				}
			}
		});

		// Add MenuItem to ContextMenu
		contextMenu.getItems().addAll(item1, item2);

		// When user right-click on Circle
		tbl_businessrules.setOnContextMenuRequested(new EventHandler < ContextMenuEvent > () {
		    @Override
		    public void handle(ContextMenuEvent event) {
//		    	BusinessRule selectedItem = tbl_businessrules.getSelectionModel().getSelectedItem();
		    	/* if(selectedItem != null) */ contextMenu.show(tbl_businessrules, event.getScreenX(), event.getScreenY());
		    }
		});
	}

	@FXML
	private void btn_generate_connect_onclick() {
		String protocol = this.cb_generate_protocol.getValue();
		String host = this.txt_generate_host.getText();
		String port = this.txt_generate_port.getText();
		if(host.equals("") || port.equals("")) {
			System.err.println("Empty");
			return;
		}

		int port_nr = Integer.parseInt(port);

		boolean result = this.connectToServer(protocol, host, port_nr);
		this.setDatabaseConnectionStatus(result, lbl_generate_dbstatus);
	}

	@FXML
	private void button_targetdb_connect_onclick() {
		boolean connectionSucces = false;

		String host = this.txt_targetdb_host.getText();
		String username = this.txt_targetdb_username.getText();
		String password = this.txt_targetdb_password.getText();
		String port = this.txt_targetdb_port.getText();
		String type = this.cb_targetdb_type.getValue();

		if(host.equals("") || username.equals("") || password.equals("") || port.equals("")) {
			System.err.println("Empty");
			return;
		}

		int port_nr = Integer.parseInt(port);

		this.targetDbContext = new TargetDbContext(type, host, port_nr, username, password);

		connectionSucces = TargetDbController.testConnection(targetDbContext);

		if (!connectionSucces)
			this.sendError("Could not connect to database");


		this.setDatabaseConnectionStatus(connectionSucces, tdb_generateStatus);
	}

	@FXML
	private void doubleClicked(MouseEvent event) {
		if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
			System.out.println(tbl_businessrules.getSelectionModel().getSelectedItem());
		}
	}

	public void sendError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Connection error");
		alert.setHeaderText(null);
		if(message != null) alert.setContentText("Error: " + message);
		alert.showAndWait();
	}
	public void sendSuccess(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		if(message != null) alert.setContentText(message);
		alert.showAndWait();
	}
	public boolean sendConfimation(String title, String body) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(body);
//	    alert.showAndWait();
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) return true;
		return false;
	}
	private void setDatabaseConnectionStatus(boolean status, Label label) {
		if(status) {
			label.setText("Connected");
			label.setStyle("-fx-background-color:green;-fx-font-weight:bold");
		} else {
			label.setText("Not connected");
			label.setStyle("-fx-background-color:red;-fx-font-weight:bold");
		}
	}
	private boolean connectToServer(String protocol, String host, int port) {
		try {
			return MainFacade.getInstance().connectToServer(protocol, host, port);
		} catch (Exception e) {
			e.printStackTrace();
			this.sendError(e.getMessage());
			return false;
		}
	}

	private void generateBusinessRule(int id) throws Exception {
		boolean success = MainFacade.getInstance().generateBusinessRule(id, targetDbContext);

		if (success)
			this.sendSuccess("Businessrule succesfully applied on " + targetDbContext.getHostname());
		else
			this.sendError("Could not apply businessrule on " + targetDbContext.getHostname());
	}
	private List<BusinessRule> getBusinessrules(){
		List<BusinessRule> rules = new ArrayList<>();

		rules = BusinessRuleService.getInstance().getAll();

		//START create example rule
		AttributeCompareRuleContext context = new AttributeCompareRuleContext(new Column("adres", "adresid"), false, Operator.GREATERTHAN, new SpecifiedValue(0));
		BusinessRule attributeCompareRule = new AttributeCompareRule("hardcodedrule", "id > 0", "FAILING!!", context);

		attributeCompareRule.setId(100);
		//END

		rules.add(attributeCompareRule);

		return rules;
	}

	@FXML
	private void searchBtnOnClick() {
		if(this.searchTextField.equals("")) return;

		List<BusinessRule> businessruleList = BusinessRuleService.getInstance().findByName(searchTextField.getText());

		if(businessruleList.isEmpty()) return;

		this.rules.clear();
		for(BusinessRule businessRule : businessruleList) {
			this.rules.add(businessRule);
		}
		this.tbl_businessrules.refresh();

	}

}
