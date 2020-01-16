package hu.tosad2019.groep4.designer.dataaccess.persistency.dao;

import hu.tosad2019.groep4.designer.dataaccess.objects.dataaccesobjects.BusinessRule;
import hu.tosad2019.groep4.designer.dataaccess.persistency.interfaces.IBusinessRuleDao;
import hu.tosad2019.groep4.designer.datainfrastructure.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusinessRuleDao extends BaseDao implements IBusinessRuleDao {

    public BusinessRuleDao() { super(); }

    public void save(BusinessRule businessRule) {
        Session session = super.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(businessRule);

        transaction.commit();
        session.close();
    }

}
