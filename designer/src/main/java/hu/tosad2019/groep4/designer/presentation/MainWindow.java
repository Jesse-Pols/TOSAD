package hu.tosad2019.groep4.designer.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow {

	private Stage stage;
	MainController controller;
	
	MainWindow() {}
	
	void create() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Form_Home.fxml"));
			Pane root = loader.load();
			this.controller = (MainController) loader.getController();
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
