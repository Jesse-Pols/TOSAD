package hu.tosad2019.groep4.designer.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow {

	private static MainWindow instance;
	private Stage stage;
	
	private MainWindow(Stage stage) {
		this.stage = stage;
		this.setupWindow();
	}
	
	public void setupWindow() {
		try {
			Pane root = new AnchorPane();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("Form_Home.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			this.stage.setScene(scene);
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void create(Stage stage) {
		MainWindow.instance = new MainWindow(stage);
	}
	public static MainWindow getInstance() {
		if(MainWindow.instance == null) System.err.println("MainWindow has not been created yet.");
		return MainWindow.instance; 
	}
	
	
}
