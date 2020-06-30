package com.wujunwen.springbootplay.BO2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IBOfactory {
    public static IBOimpl createIBOimpl(){
        final IBOimpl ibOimpl=new IBOimpl();

        final MyAspect myAspect = new MyAspect();

        IBOimpl iboProxy=(IBOimpl) Proxy.newProxyInstance(
                IBOfactory.class.getClassLoader(),
                ibOimpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object o=method.invoke(ibOimpl,args);
                        myAspect.after();
                        return o;
                    }
                });
        return iboProxy;
    }

}
