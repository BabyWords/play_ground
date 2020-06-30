package com.wujunwen.springbootplay.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("切面前");
        method.getClass().getAnnotations();
        result =method.invoke(target,args);
        System.out.println("切面后");
        return result;
    }

    public Object bind(Object target) {
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }
}
