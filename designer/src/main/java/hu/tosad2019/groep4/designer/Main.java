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
		//launch();

		BusinessRuleContext businessRuleContext = new BusinessRuleContext(BusinessRuleType.AttributeCompareRule);
		businessRuleContext.setCategory("testcategoryyyyy");

		PersistencyService ps = new PersistencyService();
		ps.saveBusinessRule(businessRuleContext);
	}

	@Override
	public void start(Stage primaryStage) {
		WindowManager.getInstance().openMainWindow();
	}
}
