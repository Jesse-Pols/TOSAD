package hu.tosad2019.groep4.designer.datainfrastructure.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    protected void delete(Object obj) {
        try {
            this.startOperation();
            this.session.delete(obj);
            this.tx.commit();
        } catch (HibernateException err) {
            this.handleException(err);
        } finally {
            HibernateFactory.close(this.session);
        }
    }

    protected Object find(Class clazz, Long id) {
        Object obj = null;

        try {
            try {
                this.startOperation();
                obj = this.session.load(clazz, id);
                this.tx.commit();
            } catch (HibernateException err) {
                this.handleException(err);
            }

            return obj;
        } finally {
            HibernateFactory.close(this.session);
        }
    }

    protected List findAll(Class clazz) {
        List objects = null;

        try {
            this.startOperation();
            Query query = this.session.createQuery("from " + clazz.getName());
            objects = query.list();
            this.tx.commit();
        } catch (HibernateException var7) {
            this.handleException(var7);
        } finally {
            HibernateFactory.close(this.session);
        }

        return objects;
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
