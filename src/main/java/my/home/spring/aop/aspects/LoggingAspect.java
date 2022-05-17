package my.home.spring.aop.aspects;

import my.home.spring.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution(* my.home.spring.aop.Library.get*())")
//    private void allGetMethodFromLibrary() {}
//
//    @Pointcut("execution(* return*())")
//    private void allReturnMethodFromLibrary(){}
//
//    @Pointcut("allGetMethodFromLibrary() || allReturnMethodFromLibrary()")
//    private void getOrReturnMethodFromLibrary(){}
//
//    @Before("allGetMethodFromLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//    @Before("allReturnMethodFromLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//    @Before("getOrReturnMethodFromLibrary()")
//    public void beforeGetOrReturnLoggingAdvice(){
//        System.out.println("beforeGetOrReturnLoggingAdvice: writing Log #3");
//    }


    private static final Logger log = Logger.getLogger(LoggingAspect.class.getName());

    @Before("my.home.spring.aop.aspects.MyPointcut.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        /**Получение сигнатуры метода бизнес логики*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature: " + signature);
        System.out.println("MethodSignature: " + signature.getMethod());
        System.out.println("MethodSignature: " + signature.getReturnType());
        System.out.println("MethodSignature: " + signature.getName());
//         System.out.println("MethodSignature: " + signature.getParameterTypes());
//        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        if (signature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Book) {
                    Book currentBook = (Book) arg;
                    System.out.println("Название:\"" + currentBook.getName()
                            + "\" автор: " + currentBook.getAuthor());
                } else if (arg instanceof String) {
                    System.out.println("Добавляет книгу пользователь: " +  arg);
                }

            }
        }


        // log.info("beforeAddLoggingAdvice: ПОПЫТКА ПОЛУЧИТЬ");
        System.out.println("beforeAddLoggingAdvice: попытка добавить книгу");
        System.out.println("__________________________________");
    }

}
