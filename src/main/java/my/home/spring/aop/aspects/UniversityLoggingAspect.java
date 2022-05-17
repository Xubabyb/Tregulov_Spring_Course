package my.home.spring.aop.aspects;

import my.home.spring.aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логгируем получение " +
                "списка студентов перед методом getStudents");
    }
//    @AfterReturning(pointcut = "execution(* getStudents())",
//    returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
//
//        students.sort(Comparator.comparingInt(Student::getCourse)/*.reversed()*/);
////          students = students.stream()
////                .sorted(Comparator.comparingDouble(Student::getAvgGrade))
////                 .collect(Collectors.toList());
//
//        Student test = students.get(0);
//        test.setNameSurname("Mr."+test.getNameSurname());
//
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логгируем получение " +
//                "списка студентов после работы метода getStudents");
//    }
//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс " +
//                "исключения " + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: логируем любое завершение" +
                " метода и нормальное и с исключением");
    }
}
