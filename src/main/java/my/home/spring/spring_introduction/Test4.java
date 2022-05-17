package my.home.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat cat = context.getBean("myPet", Cat.class);
        Cat myCat = context.getBean("myPet", Cat.class);
        System.out.println(cat);
        System.out.println(myCat);
        System.out.println(cat == myCat); //TODO true <Scope> Singleton false <Scope> Prototype


        context.close();
    }
}
