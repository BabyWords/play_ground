package com.wujunwen.springbootplay.thread2;

/**
 * @Author :wujunwen
 * @Description:
 * @Date: created in 15:44 2019/6/25
 * @Modified By:
 */

public class TrueThread implements Runnable{
      boolean   count= true;

    public   void changecount(){
        count=false;
    }

    @Override
    public void run() {
        while (count){
            System.out.println("1111");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("error");
            }
        }
    }
}
