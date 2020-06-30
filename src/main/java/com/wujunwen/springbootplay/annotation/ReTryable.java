package com.wujunwen.springbootplay.annotation;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Aspect
@Target(ElementType.METHOD)
public @com.example.demo.interface ReTryable {
    public Class retryBy() ;

    public int times() default 3;



}
