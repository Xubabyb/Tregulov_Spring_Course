package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.entity.Detail;
import my.home.spring.hibernate_test.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * OneToOne Bi-directional
 */
public class Hibernate_directional1 {


    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();

        Session session = null;
        try {
//            session = sessionFactory.getCurrentSession();
//            Employee emp = new Employee("Marat", "Shidlouski", "IT", 1500);
//            Detail detail = new Detail("Rechitsa","+3750234051698","xubabyb@mail.com");
//            /** В этом методе устанавливаем значение для поля Employee, но работник не имеет ИД
//             * так как Хибернейт его еще не контроллирует и в таблицу добавиться работник с details_id
//             * равным null*/
//            detail.setEmployee(emp);
//            /**
//             * Что бы избежать таких проблем нужно работнику передать детали*/
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(detail); //TODO Employee.empDetail=null
//
//            session.getTransaction().commit();
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 4);
            session.getTransaction().commit();

            System.out.println(detail.getEmployee());
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }


    }
}
