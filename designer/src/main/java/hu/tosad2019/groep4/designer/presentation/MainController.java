package hu.tosad2019.groep4.designer.presentation;

import hu.tosad2019.groep4.designer.dataaccess.GeneratorServer;
import hu.tosad2019.groep4.designer.dataaccess.ServerConnectionDetails;
import hu.tosad2019.groep4.designer.dataaccess.ServerConnectionException;
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
	@FXML private TableView<String> tbl_businessrules;
	@FXML private Button btn_home_add;	
	// Generate
	@FXML private Label lbl_generate_dbstatus;
	@FXML private ComboBox<String> cb_generate_protocol;
	@FXML private TextField txt_generate_host;
	@FXML private TextField txt_generate_port;
	@FXML private TextField txt_generate_password;
	@FXML private Button btn_generate_connect;
	@FXML private Button btn_generate_run;
	
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
		
		ServerConnectionDetails details = new ServerConnectionDetails(protocol, host, port_nr, password);
		boolean result = this.connectToServer(details);
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
		System.out.println("Run");
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
	private boolean connectToServer(ServerConnectionDetails details) {
		try {
			return GeneratorServer.getInstance().connect(details);
		} catch (ServerConnectionException e) {
			this.sendError(e.getMessage());
			return false;
		}
	}
}
