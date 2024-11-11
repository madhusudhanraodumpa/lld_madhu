package com.design.aoptesting;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    //execution which is nothing but pointcut.
    // 1. wild char * and ..
    //2.within
    //3.@within
    //4.args(String,int)
    //5.@annotation(org.spring.Getmpping)
    //6.@args
    //7.target-->matches any method on a particular instance of class

    @Around("execution(* com.design.aoptesting.controller.AopTesting.*())")
    public void arroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("inside before aspect method.....");
        joinPoint.proceed();
        System.out.println("inside after aspect method.....");
    }

}
