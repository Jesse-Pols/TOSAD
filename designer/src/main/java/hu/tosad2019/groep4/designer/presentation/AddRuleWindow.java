package hu.tosad2019.groep4.designer.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddRuleWindow {

	private Stage stage;
	
	AddRuleWindow() {}
	
	void create() {
		try {
			Pane root = new AnchorPane();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("Form_AddRule.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			this.stage = new Stage();
			this.stage.setScene(scene);
			this.stage.setWidth(600);
			this.stage.setHeight(450);
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
