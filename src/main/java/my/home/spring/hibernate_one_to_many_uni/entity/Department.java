package my.home.spring.hibernate_one_to_many_uni.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private List<Employee> employees;


    public Department() {
    }

    public Department(String name, int maxSalary, int minSalary) {
        this.departmentName = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployeeToDepartment(Employee... emps) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        for (Employee employee : emps) {
            employees.add(employee);
           // employee.setDepartment(this); //TODO  при добавлении работника в департамент заполняется поле работника
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
}
