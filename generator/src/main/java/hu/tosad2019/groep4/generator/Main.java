package hu.tosad2019.groep4.generator;

import hu.tosad2019.groep4.generator.domain.objects.hibernated.RangeModel;
import hu.tosad2019.groep4.generator.domain.persistency.dao.RangeDao;
import hu.tosad2019.groep4.generator.domain.persistency.interfaces.IRangeDao;
import hu.tosad2019.groep4.generator.domain.processing.ObjectService;


public class Main
{
	public static void main(String[] args) {

		IRangeDao rangeDao = new RangeDao();
		RangeModel range = new RangeModel(2, 4, 6, 8);
		rangeDao.create(range);


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

	}
}
