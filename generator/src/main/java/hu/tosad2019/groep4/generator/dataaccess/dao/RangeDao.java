package hu.tosad2019.groep4.generator.dataaccess.dao;

import hu.tosad2019.groep4.generator.dataaccess.dao.interfaces.IRangeDao;
import hu.tosad2019.groep4.generator.domain.objects.Range;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RangeDao extends BaseDao implements IRangeDao {

    public RangeDao() {
        super();
    }

    public void save(Range range) {
        Session session = super.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(range);

        transaction.commit();
        session.close();
    }

    public void update(Range range) {
        Session session = super.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(range);

        transaction.commit();
        session.close();
    }

    public void delete(Range range) {
        Session session = super.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(range);

        transaction.commit();;
        session.close();
    }

}
