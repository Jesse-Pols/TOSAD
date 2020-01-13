package hu.tosad2019.groep4.designer.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow {

	private static MainWindow INSTANCE = new MainWindow();
	private Stage stage;
	
	private MainWindow() {}
	
	public static MainWindow getInstance() {
		return MainWindow.INSTANCE; 
	}
	
	public void create(Stage stage) {
		try {
			Pane root = new AnchorPane();
			root = FXMLLoader.load(getClass().getClassLoader().getResource("Form_Home.fxml"));
			this.stage = stage;
			Scene scene = new Scene(root, 1280, 720);
			this.stage.setScene(scene);
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
