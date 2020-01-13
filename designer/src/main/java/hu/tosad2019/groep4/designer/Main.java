package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args) {
		System.out.println("Starting designer..");
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		MainWindow.getInstance().create(primaryStage);
	}
}
