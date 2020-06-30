package com.wujunwen.springbootplay.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @com.example.demo.interface ProxyAnnotation {
    ProxyType value() default ProxyType.ALL;
}
