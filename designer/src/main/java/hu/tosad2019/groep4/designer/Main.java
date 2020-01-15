package hu.tosad2019.groep4.designer;

import hu.tosad2019.groep4.designer.dataaccess.objects.domainobjects.BusinessRule;
import hu.tosad2019.groep4.designer.dataaccess.persistency.PersistencyService;
import hu.tosad2019.groep4.designer.domain.objects.Range;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.designer.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.designer.domain.objects.enums.Operator;
import hu.tosad2019.groep4.designer.presentation.WindowManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args) {
		System.out.println("Starting designer..");
		//launch();

		Range range = new Range(1, 2, Operator.and);
		AttributeRangeRuleContext attributeRangeRuleContext = new AttributeRangeRuleContext(true, 2, range);
		BusinessRule businessRule = new AttributeRangeRule("testCode_123", "testName", "testDescription", attributeRangeRuleContext);

		PersistencyService ps = new PersistencyService();
		ps.saveBusinessRule(businessRule);

	}

	@Override
	public void start(Stage primaryStage) {
		WindowManager.getInstance().openMainWindow();
	}
}
