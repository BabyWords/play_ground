package com.wujunwen.springbootplay.BO;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * BOService的代理类
 */
public class BOServiceProxy {

    public void Save(BOService boService,BO bo) throws  Exception{
        Method m = boService.getClass().getMethod("Save");

        Annotation as[] = m.getAnnotations();
        ReTryable reTryables=(ReTryable)as[0];
        try {
            boService.Save(bo);
        }catch (Exception e){
            if (reTryables.retryBy().equals(e)){
                ExceptionHandler handler=reTryables.handler().newInstance();
                handler.handleException(e);
            }
        }
    }
}
