package my.home.spring.hibernate_test.utils;

import my.home.spring.hibernate_test.entity.Detail;
import my.home.spring.hibernate_test.entity.Employee;
import my.home.spring.hibernate_test.entity_project.Role;
import my.home.spring.hibernate_test.entity_project.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static Util Instance;
    private SessionFactory sessionFactory;

    private Util() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
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
