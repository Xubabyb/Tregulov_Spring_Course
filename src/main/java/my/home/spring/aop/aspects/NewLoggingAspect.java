package my.home.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookAdvice: в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis(); //TODO засекаем время начала работы метода
        Object targetMethodResult =null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("aroundReturnBookAdvice: было поймано исключение" + e);
            //targetMethodResult = "Неизвестное название";
            throw e;
        }

        long end = System.currentTimeMillis(); //TODO засекаем время окончания работы метода

        System.out.println("aroundReturnBookAdvice: в библиотеку успешно вернули книгу");
        System.out.println("aroundReturnBookAdvice: метод returnBook выполнил" +
                " работу за " + (end - begin) + "мс");
        return targetMethodResult;
    }

}
