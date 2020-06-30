package com.wujunwen.springbootplay.volatiletest;

public class TestVolatile {
      volatile boolean status = false;

    /**
     * 状态切换为true
     */
    public void changeStatus(){
        status = true;
    }

    /**
     * 若状态为true，则running。
     */
    public void run(){
        if(status){
            System.out.println("running....");
        }
    }
}
