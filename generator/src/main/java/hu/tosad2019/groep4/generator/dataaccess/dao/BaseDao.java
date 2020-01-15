package hu.tosad2019.groep4.generator.dataaccess.dao;

import hu.tosad2019.groep4.generator.domain.objects.Range;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDao {

    protected SessionFactory sessionFactory;

    public BaseDao() {

        if (sessionFactory == null || sessionFactory.isClosed()) {
            Configuration con = new Configuration().configure().addAnnotatedClass(Range.class);
            this.sessionFactory = con.buildSessionFactory();
        }

    }

    public void close() {

        if (this.sessionFactory != null && !this.sessionFactory.isClosed()) {
            this.sessionFactory.close();
        }

    }
}
