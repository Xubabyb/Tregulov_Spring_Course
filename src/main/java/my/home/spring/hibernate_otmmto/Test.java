package my.home.spring.hibernate_otmmto;

import my.home.spring.hibernate_otmmto.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();


            session.getTransaction().commit();
        }
        finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
    }
}
