package hu.tosad2019.groep4.generator;

import java.util.HashMap;

import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule.*;
import hu.tosad2019.groep4.generator.domain.objects.Enums.Operator;
import hu.tosad2019.groep4.generator.domain.objects.Range;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.BusinessRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule.AttributeRangeRule;
import hu.tosad2019.groep4.generator.domain.objects.businessrule.attributerangerule.AttributeRangeRuleContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main
{
	public static void main(String[] args) {



		Configuration con = new Configuration();

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		session.save(null);

		/*
		 * TEMPLATES BABYYY
		 */
		/*
		String templateName = "ATTRIBUTE_COMPARE_RULE";
		HashMap<String, String> variables = new HashMap<String, String>();
		variables.put("trigger_name", "trigger_1");
		variables.put("position", "BEFORE");
		variables.put("operator", "AND");
		String replacedtemplate = TemplateParser.parse(templateName, variables);
		System.out.println(replacedtemplate);

		 */
		/*
		 * EINDE
		 */


		/*
		ServerListener server;
		try {
			server = ServerListener.create(8000);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
/*
		Range range = new Range(0, 10, Operator.and);

		AttributeRangeRuleContext rangeRuleContext = new AttributeRangeRuleContext(true, 0, range);

		BusinessRule rangeRule = new AttributeRangeRule("rr1", "rangerule 1", "dit is een testobject", rangeRuleContext);

*/

	}
}
