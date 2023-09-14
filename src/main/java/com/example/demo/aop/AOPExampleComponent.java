package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AOPExampleComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPExampleComponent.class);

    @Pointcut(value = "execution(* *.testService(..))")
    public void notificationPointcut() {
    }

    @Around(value = "notificationPointcut()")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        LOGGER.info("Execution time - " + TimeUnit.NANOSECONDS.toMillis(end - start));
        return proceed;
    }


    @AfterThrowing(value = "notificationPointcut()", throwing = "e")
    public void executionTime1(Exception e) throws Throwable {
        LOGGER.info("Execution 1 - " + e.getMessage());
    }
//
//    @After(value = "notificationPointcut() && args(message, test)")
//    public void executionTime2(String message, Boolean test) throws Throwable {
//        LOGGER.info("Execution 2 - ");
//    }

}
