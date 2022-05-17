package my.home.spring.hibernate_otmmto;

import my.home.spring.hibernate_otmmto.entity.Employee;
import my.home.spring.hibernate_otmmto.utils.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getInstance().getSessionFactory();

        Session session = null;
        try {
//            session = sessionFactory.getCurrentSession();
//
//            Department departmentIT = new Department("IT", 1500, 2500);
//            departmentIT.addEmployeeToDepartment(
//                    new Employee("Dmitriy", "Shidlouski", 1950),
//                    new Employee("Natasha", "Ivanova", 1500),
//                    new Employee("Zaur", "Tregulov", 2500));
//            session.beginTransaction();
//            session.save(departmentIT);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//**************************************************************************************************
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Department department = session.get(Department.class,1);
//            session.getTransaction().commit();
//            //TODO не ленивая загрузка сразу достает и всех работников, можем работать с ними и мимо сессии
//            department.getEmployees().forEach(System.out::println);
//            System.out.println("Done!");
// ***********************************************************************************************
//**********  Так как связь двустороння можем получить департамент из работника  ******************
// ************************************************************************************************
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class,2);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//********************************************************************************************
//******** Для удаления работников изменил тип Каскада на все кроме Remove  ******************
// ******************************************************************************************
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
    }
}
