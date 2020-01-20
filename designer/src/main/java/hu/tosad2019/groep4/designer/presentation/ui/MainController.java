package hu.tosad2019.groep4.designer.presentation.ui;

import java.util.HashMap;
import java.util.Map;

import hu.tosad2019.groep4.designer.application.application.MainFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class MainController {

	// Home
	@FXML private TableView<Map.Entry<String,String>> tbl_businessrules;
	@FXML private Button btn_home_add;	
	// Generate
	@FXML private Label lbl_generate_dbstatus;
	@FXML private ComboBox<String> cb_generate_protocol;
	@FXML private TextField txt_generate_host;
	@FXML private TextField txt_generate_port;
	@FXML private Button btn_generate_connect;
	@FXML private Button btn_generate_run;
	
	private Map<String, String> tableitems = new HashMap<>();
	
	@FXML private void initialize() {
		cb_generate_protocol.getItems().addAll("http://", "https://");
		cb_generate_protocol.getSelectionModel().selectFirst();
		tbl_businessrules.setPlaceholder(new Label("No business rules defined"));
		
//		Table
		// sample data 
        this.tableitems.put("businessrule_1", "AttributeRangeRule");
        this.tableitems.put("businessrule_2", "AttributeCompareRule");
        this.tableitems.put("businessrule_3", "AttributeRangeRule");

        this.setupTable();
		
	}
	
	@FXML 
	private void btn_home_add_onclick() {
		WindowManager.getInstance().openAddRuleWindow();
	}
	
	private void setupTable() {
		TableColumn<Map.Entry<String, String>, String> column_name = new TableColumn<>("Name");
        column_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                return new SimpleStringProperty(p.getValue().getKey());
            }
        });

        TableColumn<Map.Entry<String, String>, String> column_type = new TableColumn<>("Type");
        column_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                return new SimpleStringProperty(p.getValue().getValue());
            }
        });
        this.tbl_businessrules.getColumns().add(column_name);
        this.tbl_businessrules.getColumns().add(column_type);
        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(this.tableitems.entrySet());
        this.tbl_businessrules.getItems().addAll(items);
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
		this.setDatabaseConnectionStatus(result);
	}

	@FXML
	private void doubleClicked(MouseEvent event) {
		if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
			System.out.println(tbl_businessrules.getSelectionModel().getSelectedItem());
		}
	}
	
	@FXML
	private void btn_generate_run_onclick() {
		try {
			this.generateBusinessRule(5);
		} catch (Exception e) {
			this.sendError(e.getMessage());
		}
	}
	
	public void sendError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Connection error");
	    alert.setHeaderText(null);
		if(message != null) alert.setContentText("Error: " + message);
	    alert.showAndWait();
	}
	private void setDatabaseConnectionStatus(boolean status) {
		if(status) {
			lbl_generate_dbstatus.setText("Connected");
		    lbl_generate_dbstatus.setStyle("-fx-background-color:green;-fx-font-weight:bold");
		}else {
			lbl_generate_dbstatus.setText("Not connected");
		    lbl_generate_dbstatus.setStyle("-fx-background-color:red;-fx-font-weight:bold");
		}
	}
	private boolean connectToServer(String protocol, String host, int port) {
		try {
			return MainFacade.connectToServer(protocol, host, port);
		} catch (Exception e) {
			e.printStackTrace();
			this.sendError(e.getMessage());
			return false;
		}
	}
	
	public void generateBusinessRule(int id) throws Exception {
		MainFacade.generateBusinessRule(id);
	}
}
