package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.presentation.ui.WindowManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args) {
		System.out.println("Starting designer..");
		//launch();
		PersistencyService ps = PersistencyService.getInstance();
		ps.getAllBusinessRules();
		System.out.println("Done");



	}

	@Override
	public void start(Stage primaryStage) {
		WindowManager.getInstance().openMainWindow();
	}
}
