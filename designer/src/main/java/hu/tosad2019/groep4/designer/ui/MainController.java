package hu.tosad2019.groep4.designer.ui;

import java.io.IOException;

import hu.tosad2019.groep4.designer.communication.ServerConnection;
import hu.tosad2019.groep4.designer.exceptions.RequestFailException;
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
	    
		try {
			ServerConnection sc = new ServerConnection(protocol, host, Integer.parseInt(port), password);
			sc.send("/test", null);
			this.setDatabaseConnectionStatus(true);
			return;
		} catch(NumberFormatException e) {
			this.setDatabaseConnectionStatus(false);
			this.sendError("Port must be a number");
		} catch (IOException e) {
			this.setDatabaseConnectionStatus(false);
			this.sendError("Could not connect to server.");
		} catch (RequestFailException e) {
			this.setDatabaseConnectionStatus(false);
			if(e.getResponseCode() == 404) this.sendError("Path not found");
			else if(e.getResponseCode() == 401) this.sendError("Invalid password");
			else this.sendError("Unknown error while connecting server");
		}
	}

	@FXML
	private void doubleClicked(MouseEvent event) {
		if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
			System.out.println(homeBusinessRuleTable.getSelectionModel().getSelectedItem());
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
}
