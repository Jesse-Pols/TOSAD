package hu.tosad2019.groep4.generator.application.application;

import com.mysql.cj.xdevapi.Table;
import hu.tosad2019.groep4.generator.application.domain.objects.Column;
import hu.tosad2019.groep4.generator.application.domain.objects.Range;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.attributeotherrule.AttributeOtherRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.interentitycomparerule.InterEntityCompareRuleContext;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRule;
import hu.tosad2019.groep4.generator.application.domain.objects.businessrule.tuplecomparerule.TupleCompareRuleContext;
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
		Column column2 = new Column("TABLE_2", "COLUMN_2");
		Range range1 = new Range(0, 2, Operator.greaterThen, Operator.greaterThen);

		InterEntityCompareRuleContext iecrc = new InterEntityCompareRuleContext(column1, column2, true, Operator.greaterThen, column2.getTableName());
		InterEntityCompareRule tcr = new InterEntityCompareRule("TCMP", "TUPLE_COMPARE_RULE", iecrc);

		HashMap<String, String> variables = new HashMap<>();
		variables.put("trigger_name", "TupleCompareRule");
		variables.put("position", "BEFORE");
		variables.put("table_name", "TABLE_1");
		variables.put("for_each_row", "FOR EACH ROW");
		variables.put("column_1", "COLUMN_1");
		variables.put("column_2", "COLUMN_2");
		variables.put("operator", ">");

		String filledTemplate = TemplateParser.parse(tcr, variables);
		System.out.println(filledTemplate);
	}
}
