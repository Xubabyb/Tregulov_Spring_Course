package my.home.spring.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut("execution(* addпокаоставлюэтотут*(..))") //TODO мешает выводу теста 2
    public void allAddMethods(){}
}
