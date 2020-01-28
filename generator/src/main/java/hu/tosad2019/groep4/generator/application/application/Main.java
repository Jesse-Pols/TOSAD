package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.Range;
import hu.tosad2019.groep4.generator.application.domain.objects.SpecifiedValue;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributecomparerule.AttributeCompareRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.enums.Operator;
import hu.tosad2019.groep4.generator.dataaccess.communication.ServerListener;
import org.hibernate.sql.Template;

import java.net.URL;
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

//		AttributeRangeRuleContext arrc = new AttributeRangeRuleContext(true, true, column1, range1);
//		AttributeRangeRule ar = new AttributeRangeRule("101", "ATTRIBUTE_RANGE_RULE", arrc);

		AttributeCompareRuleContext acrc = new AttributeCompareRuleContext(column1, false, Operator.greaterThen, new SpecifiedValue(0));
		AttributeCompareRule acr = new AttributeCompareRule("ACR", "ATTRIBUTE_COMPARE_RULE", acrc);

		HashMap<String, String> variables = new HashMap<>();
		variables.put("trigger_name", "ComapareRule");
		variables.put("position", "BEFORE");
		variables.put("table_name", "TABLE_1");
		variables.put("for_each_row", "FOR EACH ROW");
		variables.put("column1", "COLUMN_1");
		variables.put("operator", ">");
		variables.put("value", "0");

		String filledTemplate = TemplateParser.parse(acr, variables);
		System.out.println(filledTemplate);
	}
}
