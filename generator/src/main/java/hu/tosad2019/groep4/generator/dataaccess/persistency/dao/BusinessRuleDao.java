package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range;
import hu.tosad2019.groep4.generator.dataaccess.persistency.IBusinessRuleDao;
import hu.tosad2019.groep4.generator.datainfrastructure.BaseDao;
import org.hibernate.Session;

public class BusinessRuleDao extends BaseDao implements IBusinessRuleDao {
    public BusinessRule getById(int id) {
        Session session = super.sessionFactory.openSession();
        BusinessRule businessRule = session.get(BusinessRule.class, id);

        session.close();
        return businessRule;
    }
}
