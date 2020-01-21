package hu.tosad2019.groep4.designer.presentation.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddRuleWindow {

	private Stage stage;
	AddRuleController controller;
	private boolean active;
	
	AddRuleWindow() {}
	
	public boolean isActive() {
		return this.active;
	}
	public void focus() {
		this.stage.requestFocus();
	}
	
	void create() {
		this.active = true;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Form_AddRule.fxml"));
			Pane root = loader.load();
			this.controller = (AddRuleController) loader.getController();
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
	
	void close() {
		this.stage.close();
	}
	
	
}
