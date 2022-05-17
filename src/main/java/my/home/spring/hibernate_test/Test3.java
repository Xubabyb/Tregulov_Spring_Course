package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> employeeList = session.createQuery("from Employee")
//                    .getResultList();
//            employeeList.forEach(System.out::println);
            List<Employee> employeeList = session
                    .createQuery("from Employee where " +
                            "name = 'Alexsander' and salary>2000") //TODO name-название поля в классе
                    .getResultList();                              //TODO-название класса,а не таблицы
            employeeList.forEach(System.out::println);

            session.getTransaction().commit();
//            System.out.println(emp);
        } finally {
            sessionFactory.close();
        }
    }
}
