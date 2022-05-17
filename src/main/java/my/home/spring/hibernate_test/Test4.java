package my.home.spring.hibernate_test;

import my.home.spring.hibernate_test.utils.Util;
import my.home.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();


        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(9999);

//            List<Employee> employeeList = session.createQuery("from Employee where  name ='Alexsander'")
//                    .getResultList();
//            for (Employee temp : employeeList) {
//                temp.setSalary(3999);
//            }
            session.createQuery("update Employee set salary = 9950 where name = 'Alexsander'")
                    .executeUpdate();

            session.getTransaction().commit();
//            System.out.println(employeeList);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class,1);
            employee.setDepartment("HR");
            session.getTransaction().commit();
            System.out.println(employee);
        } finally {
            sessionFactory.close();
        }
    }
}
