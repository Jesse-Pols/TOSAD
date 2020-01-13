package hu.tosad2019.groep4.designer.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddRuleWindow {

	private static AddRuleWindow INSTANCE = new AddRuleWindow();
	private Stage stage;
	
	private AddRuleWindow() {}
	
	public static AddRuleWindow getInstance() {
		return AddRuleWindow.INSTANCE; 
	}
	
	public void create() {
		try {
			Pane root = new AnchorPane();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("Form_AddRule.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			this.stage = new Stage();
			this.stage.setScene(scene);
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
