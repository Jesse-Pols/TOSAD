package hu.tosad2019.groep4.generator.dataaccess.persistency.dao;

import hu.tosad2019.groep4.generator.dataaccess.objects.dataaccesobjects.Range;
import hu.tosad2019.groep4.generator.dataaccess.persistency.IRangeDao;
import hu.tosad2019.groep4.generator.datainfrastructure.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RangeDao extends BaseDao implements IRangeDao {

    public RangeDao() {
        super();
    }

    public Range getById(int id) {
        Session session = super.sessionFactory.openSession();
        Range range = session.get(Range.class, id);

        session.close();
        return range;
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
