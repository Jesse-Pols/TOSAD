package hu.tosad2019.groep4.tosad.ui;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	@FXML Button button1;
	
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
	
}
