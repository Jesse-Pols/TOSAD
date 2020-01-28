package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.application.domain.processing.BusinessRuleContext;
import hu.tosad2019.groep4.designer.application.domain.processing.enums.BusinessRuleType;
import hu.tosad2019.groep4.designer.application.storage.PersistencyService;
import hu.tosad2019.groep4.designer.presentation.ui.WindowManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application
{
	public static void main(String[] args) {
		System.out.println("Starting designer..");
		//launch();

		PersistencyService ps = PersistencyService.getInstance();

		BusinessRuleContext context = new BusinessRuleContext(BusinessRuleType.AttributeRangeRule);
		context.setCategory("testCategory");
		context.setTemplate("testTemplate");
		context.setName("testName2");
		context.setDescription("testDescription");
		context.setFailure("testFailure");
		context.setIsNot(2);
		context.setStatement("testStatement");

		List<String> values = new ArrayList<>();
		values.add("value1");
		values.add("value2");
		values.add("value3");
		context.setBusinessRuleValues(values);
		context.setListValues(values);

		System.out.println(ps.saveBusinessRule(context));
	}

	@Override
	public void start(Stage primaryStage) {
		WindowManager.getInstance().openMainWindow();
	}
}
