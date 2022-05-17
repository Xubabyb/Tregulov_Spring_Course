package my.home.spring.spring_introduction;

import my.home.spring.spring_introduction.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean",Person.class);
        person.callYourPet();
        context.close();
    }
}
