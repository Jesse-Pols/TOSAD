package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.dataaccess.objects.Range;
import hu.tosad2019.groep4.designer.dataaccess.persistency.IRangeDao;
import hu.tosad2019.groep4.designer.dataaccess.persistency.dao.RangeDao;
import hu.tosad2019.groep4.designer.presentation.WindowManager;
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
		WindowManager.getInstance().openMainWindow();
	}
}
