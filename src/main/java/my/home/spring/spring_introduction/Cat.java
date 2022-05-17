package my.home.spring.spring_introduction;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }

    //@PostConstruct
    private void init() {
        System.out.println("Class Cat init method");
    }

    //@PreDestroy
    private void destroy() {
        System.out.println("Class Cat destroy method");
    }
}
