package my.home.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("method main starts");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        String str = context.getBean("library", Library.class).returnBook();

        System.out.println("Вернули книгу: " + str);


        context.close();
        System.out.println("method main ends");
    }
}
