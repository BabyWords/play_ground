package com.wujunwen.springbootplay.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class Aspecthandler {


    @Around("@annotation(com.wujunwen.springbootplay.annotation.PersonAnnotation)")
    public void HandleName(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法名和注解
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        PersonAnnotation personAnnotation = method.getDeclaredAnnotation(PersonAnnotation.class);

        Object result;
        result = joinPoint.proceed(joinPoint.getArgs());
        System.out.println(personAnnotation.name());

    }
}
