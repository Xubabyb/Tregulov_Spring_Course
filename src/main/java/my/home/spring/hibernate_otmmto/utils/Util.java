package my.home.spring.hibernate_otmmto.utils;

import my.home.spring.hibernate_otmmto.entity.Department;
import my.home.spring.hibernate_otmmto.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static Util Instance;
    private SessionFactory sessionFactory;

    private Util() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
    }

    public static Util getInstance() {
        if (Instance == null) {
            Instance = new Util();
        }
        return Instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
