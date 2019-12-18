package hu.tosad2019.groep4.designer.ui;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

	@FXML Button button1;
	@FXML TableView homeBusinessRuleTable;
	@FXML TextField dbConnectionInput;
	
	@FXML
	private void button1_onclick() {
	    // Button was clicked, do something�
	    System.out.println("Click");
	}
	
	@FXML
	private void button1_onhover() {
	    // Button was clicked, do something�
	    System.out.println("Hover");
	}

	@FXML
	private void doubleClicked(MouseEvent event) {
		if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
			System.out.println(homeBusinessRuleTable.getSelectionModel().getSelectedItem());
		}
	}

	@FXML
	private void getDbConnection() {
		String dbUrl = dbConnectionInput.getText();

		//give dbUrl to someone


	}
}
