package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {
            Session session = sessionFactory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Sidorov", "IT", 1800);
            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();
            int myId = emp.getId();
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
            emp = session.get(Employee.class, myId);
//            employee.setDepartment("Sales");
            session.getTransaction().commit();
            System.out.println(emp);
        } finally {
            sessionFactory.close();
        }
    }
}
