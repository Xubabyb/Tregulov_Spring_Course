package my.home.spring.hibernate_one_to_many_uni;


import my.home.spring.hibernate_one_to_many_uni.entity.Department;
import my.home.spring.hibernate_one_to_many_uni.entity.Employee;
import my.home.spring.hibernate_one_to_many_uni.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();

        Session session = null;
        try {
//            Department departmentIT = new Department("HR", 1500, 3500);
//            departmentIT.addEmployeeToDepartment(
//                    new Employee("Dmitriy", "Shidlouski", 1950),
//                    new Employee("Natasha", "Ivanova", 1500),
//                    new Employee("Ivan", "Ivanov", 3500));
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.save(departmentIT);
//            session.getTransaction().commit();
//****************************************************************************************************
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 2);
            System.out.println(department);
            session.getTransaction().commit();
            System.out.println("Done!");
            System.out.println(department.getEmployees());

        } finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
    }
}
