package hu.tosad2019.groep4.generator;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range;
import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.BusinessRuleDao;
import hu.tosad2019.groep4.generator.dataaccess.persistency.dao.RangeDao;
import hu.tosad2019.groep4.generator.domain.processing.ObjectService;


public class Main
{
	public static void main(String[] args) {

		ObjectService os = new ObjectService();
		os.getBusinessRule(21);

		//PersistencyService ps = new PersistencyService();
		//ps.getBusinessRuleById(21);

		/*
		RangeDao rangeDao = new RangeDao();
		Range range = rangeDao.find(1);

		BusinessRuleDao brDao = new BusinessRuleDao();
		BusinessRule businessRule = brDao.find(21);

		System.out.println("Done");

		 */




		//Range range = rangeDao.getById(3);

		//hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range range = new hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range(6,9, 2, 1);

		//rangeDao.save(range);

		/*
		Configuration con = new Configuration().configure().addAnnotatedClass(Range.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(range);

		tx.commit();
		 */

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
