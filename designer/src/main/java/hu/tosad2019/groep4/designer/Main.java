package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.PersistencyService;
import hu.tosad2019.groep4.designer.presentation.ui.WindowManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args) {
		System.out.println("Starting designer..");
		launch();

		/*
		PersistencyService ps = PersistencyService.getInstance();

		BusinessRuleContext context = new BusinessRuleContext(BusinessRuleType.AttributeCompareRule);
		context.setCategory("testCategory");
		context.setTemplate("testTemplate");
		context.setName("testName");
		context.setDescription("testDescription");
		context.setFailure("testFailure");
		context.setIsNot(2);
		context.setStatement("testStatement");

		ps.saveBusinessRule(context);
		 */


	}

	@Override
	public void start(Stage primaryStage) {
		WindowManager.getInstance().openMainWindow();
	}
}
