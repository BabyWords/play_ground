package com.wujunwen.springbootplay;

/**
 * @Author :wujunwen
 * @Description: 测试对象的共享
 * @Date: created in 15:04 2019/6/20
 * @Modified By:
 */
public class Novisibility {
    private static  boolean ready=false;
    private static int number=0;
    private  static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (!ready){
                System.out.println(111);
                Thread.yield();
                System.out.println(number);
            }
        }
    }
    public static void main(String args[]){
        new ReaderThread().start();
        number=42;
        ready = true;
    }
}
