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
	@FXML TableView<String> tbl_businessrules;
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
		tbl_businessrules.setPlaceholder(new Label("No business rules defined"));
	}
	
	@FXML 
	private void btn_home_add_onclick() {
		AddRuleWindow.getInstance().create();
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
		
		int port_nr = Integer.parseInt(port);
		
		boolean result = this.connectToServer(protocol, host, port_nr, password);
		this.setDatabaseConnectionStatus(result);
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
	private void setDatabaseConnectionStatus(boolean status) {
		if(status) {
			lbl_generate_dbstatus.setText("Connected");
		    lbl_generate_dbstatus.setStyle("-fx-background-color:green;-fx-font-weight:bold");
		}else {
			lbl_generate_dbstatus.setText("Not connected");
		    lbl_generate_dbstatus.setStyle("-fx-background-color:red;-fx-font-weight:bold");
		}
	}
	private boolean connectToServer(String protocol, String host, int port, String password) {
		try {
			ServerConnection sc = new ServerConnection(protocol, host, port, password);
			sc.send("/test", null);
			return true;
		} catch(NumberFormatException e) {
			this.sendError("Port must be a number");
		} catch (IOException e) {
			this.sendError("Could not connect to server.");
		} catch (RequestFailException e) {
			if(e.getResponseCode() == 404) this.sendError("Path not found");
			else if(e.getResponseCode() == 401) this.sendError("Invalid password");
			else this.sendError("Unknown error while connecting server");
		}
		return false;
	}
}
