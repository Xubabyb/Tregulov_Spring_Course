package my.home.spring.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        students.add(new Student("Dmitriy Shi",4,9.8));
        students.add(new Student("Vasy Vaskin",2,6.8));
        students.add(new Student("Petr Petrov",3,7.8));
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents(){
        System.out.println("Начало работы метода getStudents");
        System.out.println(students.get(3)); //TODO эта строка выбрасывает исключение
        System.out.println("information from method getStudents: ");
        System.out.println(students);

        return students;
    }
}
