package com.wujunwen.springbootplay.BO3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 重试切面,处理重试的机制
 */
@Aspect
@Component
public class RetryHandler {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "@annotation(com.wujunwen.springbootplay.BO3.ReTryable)")
    public Object retry(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            //反射获取对象
            Object object = joinPoint.getTarget();
            Field field = object.getClass().getDeclaredField("threadLocal");
            field.setAccessible(true);
            //线程安全变量
            ThreadLocal<AtomicInteger> threadLocal = (ThreadLocal<AtomicInteger>) field.get(object);
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            //获取注解信息
            ReTryable reTryable = method.getDeclaredAnnotation(ReTryable.class);
            AtomicInteger atomicInteger=threadLocal.get();
            //重试以及判断重试次数
            if (atomicInteger.intValue() < reTryable.retryTime()) {
                int count=atomicInteger.incrementAndGet();
                try {
                    result = joinPoint.proceed();
                } catch (Throwable throwable) {
                    //todo 如何直接判断是ConnecttionReset 错误?
                    if (throwable.getMessage().contains(reTryable.retryException().getName())){
                        //发现是指定异常,则开始重试
                        logger.warn("retry...times:{}",count);
                        retry(joinPoint);
                    }
                }
            }
        }
        catch (Throwable throwable){
            logger.error("excute error",throwable);
        }
        return result;
    }
}
