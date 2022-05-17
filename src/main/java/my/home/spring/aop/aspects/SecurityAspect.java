package my.home.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(2)
public class SecurityAspect {

    private static final Logger log = Logger.getLogger(SecurityAspect.class.getName());

    @Before("my.home.spring.aop.aspects.MyPointcut.allAddMethods()")
    public void beforeAddSecurityAdvice() {
//        log.info("beforeAddSecurityAdvice: ПРОВЕРКА ПРАВ");
        System.out.println("beforeAddSecurityAdvice: проверка прав на получение книги");
        System.out.println("__________________________________");
    }
}
