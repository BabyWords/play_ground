package com.wujunwen.springbootplay.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheHandler {

    //缓存更新的切点
    @AfterReturning(value = "@annotation(com.wujunwen.springbootplay.cache.CachePut)",returning = "result")
    public void handlePut(ProceedingJoinPoint joinPoint,Object result) throws Throwable{
        if (result instanceof Person){
            //存入缓存
           if(checkSize((Person)result)){
               //todo 同时操作两个原子变量也不一定线程安全,待完善
               PersonCache.personHashMap.put(((Person) result).getId(),(Person)result);
               //更新缓存使用时间
               PersonCache.useRecord.put(((Person) result).getId(),System.currentTimeMillis());
           }
        }
    }

    //获取缓存的切点
    @Before("@annotation(com.wujunwen.springbootplay.cache.CacheGet)")
    public Person handlGet(ProceedingJoinPoint joinPoint) throws Throwable{
        Object args[]=joinPoint.getArgs();
        for (Object o:args) {
            if (o instanceof Integer){
                //如果存在缓存,从缓存中获取
                if (PersonCache.personHashMap.containsKey(o)){
                    //更新使用时间
                    PersonCache.useRecord.put((Integer) o,System.currentTimeMillis());
                    return PersonCache.personHashMap.get(o);
                }
            }
        }
        //没有缓存则方法继续
        return (Person)joinPoint.proceed();

    }

    /**
     * 检查缓存size并且判断是否可以继续缓存
     * 如果已经超过大小则不允许在存入
     * @param person
     * @return
     */
    public Boolean checkSize(Person person){
        if (PersonCache.personHashMap.size()>100){
            return false;
        }
        return true;
    }

}
