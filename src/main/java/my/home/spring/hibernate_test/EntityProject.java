package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.entity_project.Role;
import my.home.spring.hibernate_test.entity_project.User;
import my.home.spring.hibernate_test.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EntityProject {
    public static void main(String[] args) {


        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


//            Role role = new Role("ENROLLEE");
            List<Role> list = session.createQuery("from Role").getResultList();

            Role role = list.stream().filter(x -> x.getName().equals("ENROLLEE")).findFirst().get();


            User user = new User("vas@mail.com", "Vasy", "Ivanov");
            user.setRole(role);
            session.save(user);
//            session.createQuery("delete Employee where name = 'Alexsander'")
//                            .executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
