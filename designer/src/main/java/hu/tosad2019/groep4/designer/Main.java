package hu.tosad2019.groep4.designer;

import java.io.IOException;

import hu.tosad2019.groep4.designer.communication.ServerConnection;
import hu.tosad2019.groep4.designer.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{	
	public static void main(String[] args) {
		ServerConnection sc = new ServerConnection("localhost", 8000, "vMDhvChAYbRcF4dG", false);
		sc.open();
		try {
			sc.send();
		} catch (IOException e) {
			System.err.println("Could not connect");
		}
		
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) {
		MainWindow.create(primaryStage);
	}
}
