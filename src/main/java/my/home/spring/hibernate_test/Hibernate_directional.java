package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.entity.Employee;
import my.home.spring.hibernate_test.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hibernate_directional {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();

        Session session = null;
        try {
//            Session session = sessionFactory.getCurrentSession();
//            Employee emp = new Employee("Dmitriy", "Shidlouski", "IT", 2500);
//            Detail detail = new Detail("Rechitsa","+3750234051698","xubabyb@mail.com");
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

           //___________________________________________________________________________________

//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 10);
//            emp.setSalary(999); //TODO Connection leak detected: транзакция не закоммитилась emp пришел null
//            session.getTransaction().commit();
//
//            System.out.println(emp);
//            System.out.println(emp.getEmpDetail());//TODO emp может прийти null если запросить ИД которого нет

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class,2);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }


    }
}
