package hu.tosad2019.groep4.generator.datainfrastructure;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private static SessionFactory sessionFactory;

    public HibernateFactory() {}

    public static SessionFactory buildSessionFactory() throws HibernateException {
        if (sessionFactory != null) {
            closeFactory();
        }

        return configureSessionFactory();
    }

    public static SessionFactory buildIfNeeded() throws DataAccessLayerException {
        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            try {
                return configureSessionFactory();
            } catch (HibernateException err) {
                System.err.println(err);
                throw new DataAccessLayerException((err));
            }
        }
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }

    public static Session openSession() throws HibernateException {
        buildIfNeeded();
        return sessionFactory.openSession();
    }

    public static void closeFactory() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException err) {
                System.err.println("Couldn't close SessionFactory");
                System.err.println(err);
            }
        }
    }

    public static void close(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException err) {
                System.err.println("Couldn't close session.");
                System.err.println(err);
            }
        }
    }

    public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException err) {
            System.err.println("Couldn't rollback Transaction");
            System.err.println(err);
        }
    }

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
