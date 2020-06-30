package com.wujunwen.springbootplay.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncPlay {
private static final int A=1;
    @Async
    public void  as(){
        int ee=A+1;
        System.out.println("111");
    }

    @Async
    public  void as2(){
        System.out.println("222");
    }
}
