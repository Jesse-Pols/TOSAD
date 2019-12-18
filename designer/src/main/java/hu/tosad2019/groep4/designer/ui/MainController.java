package hu.tosad2019.groep4.designer.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

	// Home
	@FXML TableView<String> homeBusinessRuleTable;
	@FXML Button btn_home_add;	
	// Generate
	@FXML Label lbl_generate_dbstatus;
	@FXML ComboBox<String> cb_generate_protocol;
	@FXML TextField txt_generate_host;
	@FXML TextField txt_generate_port;
	@FXML TextField txt_generate_password;
	@FXML Button btn_generate_connect;
	
	@FXML private void initialize() {
		cb_generate_protocol.getItems().addAll("http://", "https://");
		cb_generate_protocol.getSelectionModel().selectFirst();
	}
	
	@FXML 
	private void btn_home_add_onclick() {
		System.out.println("Click");
	}
	
	@FXML
	private void btn_generate_connect_onclick() {
		String protocol = this.cb_generate_protocol.getValue();
		String host = this.txt_generate_host.getText();
		String port = this.txt_generate_port.getText();
		String password = this.txt_generate_password.getText();
		if(host.equals("") || port.equals("") || password.equals("")) {
			System.err.println("Empty");
			return;
		}
		
		String url = String.format("%s%s:%s/test", protocol, host, port, password);
	    System.out.println("Connect to: " + url);
	    this.sendServerConnectionError("Host not found");
	    this.setDatabaseConnectionStatus(true);
	}

	@FXML
	private void doubleClicked(MouseEvent event) {
		if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
			System.out.println(homeBusinessRuleTable.getSelectionModel().getSelectedItem());
		}
	}
	
	
	public void sendServerConnectionError() {
		this.sendServerConnectionError(null);
	}
	public void sendServerConnectionError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Connection error");
	    alert.setHeaderText(null);
		if(message != null) alert.setContentText("Error: Could not connect to server.\n\nReason: " + message);
		else alert.setContentText("Error: Could not connect to server.");
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
}
