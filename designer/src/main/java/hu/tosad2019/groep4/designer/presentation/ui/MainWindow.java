package hu.tosad2019.groep4.designer.presentation.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class  MainWindow {

	private Stage stage;
	MainController controller;
	boolean active;
	
	MainWindow() {}
	
	public boolean isActive() {
		return this.active;
	}
	public void focus() {
		this.stage.requestFocus();
	}
	
	void create() {
		this.active=true;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Form_Home.fxml"));
			Pane root = loader.load();
			this.controller = (MainController) loader.getController();
			Scene scene = new Scene(root, 1280, 720);
			scene.getStylesheets().add("/application.css");
			this.stage = new Stage();
			this.stage.setScene(scene);
			this.stage.setWidth(700);
			this.stage.setHeight(500);
			this.stage.setTitle("BusinessRuleGenerator");
			this.stage.show();
			this.stage.setOnCloseRequest(event -> {
				WindowManager.getInstance().closeall();
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
