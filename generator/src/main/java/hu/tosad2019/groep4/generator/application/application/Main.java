package hu.tosad2019.groep4.generator.application.application;

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

		HashMap<String, String> vars = new HashMap<String, String>();
		vars.put("column1", "testColumn1");
		vars.put("operator", ">");
		vars.put("value", "10");


		TemplateParser.parse("ATTRIBUTE_COMPARE_RULE", vars);

	}
}
