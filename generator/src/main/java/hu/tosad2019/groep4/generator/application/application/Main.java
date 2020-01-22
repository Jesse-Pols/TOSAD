package hu.tosad2019.groep4.generator.application.application;

import hu.tosad2019.groep4.generator.dataaccess.communication.ServerListener;


public class Main
{
	public static void main(String[] args) {



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

		ServerListener server;
		try {
			server = ServerListener.create(8000);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
