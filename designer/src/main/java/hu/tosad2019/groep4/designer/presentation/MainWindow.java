package hu.tosad2019.groep4.designer.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow {

	private Stage stage;
	
	MainWindow() {}
	
	void create() {
		try {
			Pane root = new AnchorPane();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("Form_Home.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			this.stage = new Stage();
			this.stage.setScene(scene);
			this.stage.setWidth(700);
			this.stage.setHeight(500);
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
