package hu.tosad2019.groep4.generator.dataaccess.storage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AbstractDao {
    private Session session;
    private Transaction tx;

    public AbstractDao() {
        HibernateFactory.buildIfNeeded();
    }

    protected int saveOrUpdate(Object obj) {
        int result = 0;

        try {
            this.startOperation();
            result = (Integer) this.session.save(obj);
            this.tx.commit();
        } catch (HibernateException err) {
            this.handleException(err);
        } finally {
            HibernateFactory.close(this.session);
        }

        return result;
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

    protected Object find(Class<?> clazz, int id) {
        Object obj = null;

        try {
            try {
                this.startOperation();
                obj = this.session.get(clazz, id);
                this.tx.commit();
            } catch (HibernateException err) {
                this.handleException(err);
            }

            return obj;
        } finally {
            HibernateFactory.close(this.session);
        }
    }

    protected List<?> findAll(Class<?> clazz) {
        List<?> objects = null;

        try {
            this.startOperation();
            Query query = this.session.createQuery("from " + clazz.getName());
            objects = query.getResultList();
            this.tx.commit();
        } catch (HibernateException err) {
            this.handleException(err);
        } finally {
            HibernateFactory.close(this.session);
        }

        return objects;
    }

    protected List<?> findAll(Class<?> clazz, String where) {
        // Remember: put apostrophes around the where clause if it's a string -> 'where'
        List objects = null;

        try {
            this.startOperation();
            Query query = this.session.createQuery("from " + clazz.getName() + " where " + where);
            objects = query.getResultList();
            this.tx.commit();
        } catch (HibernateException err) {
            this.handleException(err);
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
