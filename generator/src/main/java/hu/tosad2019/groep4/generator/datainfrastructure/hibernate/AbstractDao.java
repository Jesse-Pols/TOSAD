package hu.tosad2019.groep4.generator.datainfrastructure.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDao {
    private Session session;
    private Transaction tx;

    public AbstractDao() {
        HibernateFactory.buildIfNeeded();
    }

    protected void saveOrUpdate(Object obj) {
        try {
            this.startOperation();
            this.session.saveOrUpdate(obj);
            this.tx.commit();
        } catch (HibernateException err) {
            this.handleException(err);
        } finally {
            HibernateFactory.close(this.session);
        }
    }

    protected void handleException(HibernateException err) throws DataAccessLayerException {
        HibernateFactory.rollback(this.tx);
        throw new DataAccessLayerException(err);
    }

    protected void startOperation() throws HibernateException {
        this.session = HibernateFactory.openSession();
        this.tx = this.session.beginTransaction();
    }
}
