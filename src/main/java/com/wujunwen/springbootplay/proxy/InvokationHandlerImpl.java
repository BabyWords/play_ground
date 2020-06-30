package com.wujunwen.springbootplay.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvokationHandlerImpl implements InvocationHandler {
    private Object target;
    private TransactionProxy transactionProxy;
    //构造器 得到被代理对象和代理处理器
    public InvokationHandlerImpl(Object target, TransactionProxy transactionProxy) {
        this.target = target;
        this.transactionProxy = transactionProxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法上的代理注解
        ProxyAnnotation annotation = (ProxyAnnotation)method.getDeclaredAnnotation(ProxyAnnotation.class);
        Object result = null;
        //代理注解为执行前代理，则依靠处理器返回值判断决定是否执行原代理方法，如果为权限验证，在代理处理器中验证不通过时返回false即可阻止后续执行
        if(annotation.value() == ProxyType.BEFORE){
            if(transactionProxy.before()){
                result = method.invoke(target, args);
            }
            //代理注解为执行后处理则不存在是否执行原代理方法的判断
        }else if(annotation.value() == ProxyType.AFTER){
            result = method.invoke(target, args);
            transactionProxy.after();
            //前后都执行
        }else if(annotation.value() == ProxyType.ALL){
            transactionProxy.before();
            result = method.invoke(target, args);
            transactionProxy.after();
        }
        return result;
    }


}
