package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.PersistencyService;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleCategoryModel;
import hu.tosad2019.groep4.designer.application.storage.objects.BusinessRuleModel;
import hu.tosad2019.groep4.designer.application.storage.objects.TemplateModel;
import hu.tosad2019.groep4.designer.dataaccess.storage.AbstractDao;
import hu.tosad2019.groep4.designer.presentation.ui.WindowManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

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
