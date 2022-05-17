package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.utils.Util;
import my.home.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test5 {
    public static void main(String[] args) {


        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class,2);
//            session.delete(employee);

            session.createQuery("delete Employee where name = 'Alexsander'")
                            .executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
