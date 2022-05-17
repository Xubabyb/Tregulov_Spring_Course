package my.home.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    private static final Logger log = Logger.getLogger(SecurityAspect.class.getName());

    @Before("my.home.spring.aop.aspects.MyPointcut.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice() {
       // log.info("beforeAddExceptionHandlingAdvice: Обработка ошибок");
        System.out.println("beforeAddExceptionHandlingAdvice: обработка ошибок при получение книги");
        System.out.println("__________________________________");
    }
}
