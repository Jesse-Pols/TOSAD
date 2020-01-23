package hu.tosad2019.groep4.designer.presentation.ui;

import java.util.List;
import java.util.Optional;

import hu.tosad2019.groep4.designer.application.application.MainFacade;
import hu.tosad2019.groep4.designer.application.domain.objects.businessrule.BusinessRule;
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
	@FXML private ComboBox<String> cb_generate_protocol;
	@FXML private TextField txt_generate_host;
	@FXML private TextField txt_generate_port;
	@FXML private Button btn_generate_connect;
	
	private ObservableList<BusinessRule> rules; 
	
	@FXML private void initialize() {
		cb_generate_protocol.getItems().addAll("http://", "https://");
		cb_generate_protocol.getSelectionModel().selectFirst();
		tbl_businessrules.setPlaceholder(new Label("No business rules defined"));		

		this.rules = FXCollections.observableArrayList(getBusinessrules());
		
        this.setupTable();
        this.setupContextMenu();
	}
	
	@FXML 
	private void btn_home_add_onclick() {
		WindowManager.getInstance().openAddRuleWindow();
	}
	
	private void setupTable() {
		TableColumn<BusinessRule, String> column_name = new TableColumn<>("ID");

        column_name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessRule, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BusinessRule, String> p) {
            	BusinessRule rule = p.getValue();
                return new SimpleStringProperty(rule!=null?Integer.toString(rule.getId()):"No ID");
            }
        });

        TableColumn<BusinessRule, String> column_type = new TableColumn<>("Name");
        column_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BusinessRule, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BusinessRule, String> p) {
            	BusinessRule rule = p.getValue();
                return new SimpleStringProperty(rule!=null?rule.getName():"No Name");
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
		    	}
		        
		    }
		});
		MenuItem item2 = new MenuItem("Generate");
		item2.setOnAction(new EventHandler < ActionEvent > () {

		    @Override
		    public void handle(ActionEvent event) {
		    	int name = tbl_businessrules.getSelectionModel().getSelectedItem().getId();
		    	try {
		    		generateBusinessRule(name);
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
		    	BusinessRule selectedItem = tbl_businessrules.getSelectionModel().getSelectedItem();
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
			return MainFacade.getInstance().connectToServer(protocol, host, port);
		} catch (Exception e) {
			e.printStackTrace();
			this.sendError(e.getMessage());
			return false;
		}
	}
	
	private void generateBusinessRule(int name) throws Exception {
		MainFacade.getInstance().generateBusinessRule(name);
	}
	private List<BusinessRule> getBusinessrules(){
		BusinessRuleService brs = new BusinessRuleService();
		List<BusinessRule> rules = brs.getAll();
		return rules;
	}
}
