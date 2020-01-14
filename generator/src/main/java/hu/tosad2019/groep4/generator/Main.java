package hu.tosad2019.groep4.generator;

import java.util.HashMap;

//import hu.tosad2019.groep4.generator.domain.businessrule.attributerangerule.AttributeRangeRule;

public class Main
{
	public static void main(String[] args) {
		/*
		 * TEMPLATES BABYYY
		 */
		String templateName = "ATTRIBUTE_COMPARE_RULE";
		HashMap<String, String> variables = new HashMap<String, String>();
		variables.put("trigger_name", "trigger_1");
		variables.put("position", "BEFORE");
		variables.put("operator", "AND");
		String replacedtemplate = TemplateParser.parse(templateName, variables);
		System.out.println(replacedtemplate);
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

		AttributeRangeRule.Builder test = new AttributeRangeRule.Builder();
		test.setTriggerName("Hree");
		AttributeRangeRule attribute = test.build();

		 */
		
		
	}
}
