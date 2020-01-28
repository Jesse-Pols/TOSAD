package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.Range;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.generator.dataaccess.communication.ServerListener;
import java.util.HashMap;


public class Main
{
	public static void main(String[] args) {
		ServerListener server;
		try {
			server = ServerListener.create(8000);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Column column1 = new Column("TABLE_1", "COLUMN_1");
		Range range1 = new Range(0, 2, Operator.greaterThen, Operator.greaterThen);

		AttributeOtherRuleContext aorc = new AttributeOtherRuleContext(column1, Operator.greaterThen, "SELECT * FROM TABLE1");
		AttributeOtherRule aor = new AttributeOtherRule("AOTH", "ATTRIBUTE_OTHER_RULE", aorc);

		HashMap<String, String> variables = new HashMap<>();
		variables.put("trigger_name", "OtherRule");
		variables.put("position", "BEFORE");
		variables.put("table_name", "TABLE_1");
		variables.put("for_each_row", "FOR EACH ROW");
		variables.put("column1", "COLUMN_1");
		variables.put("trigger_code", "IF COLUMN_1 > 2");

		String filledTemplate = TemplateParser.parse(aor, variables);
		System.out.println(filledTemplate);
	}
}
