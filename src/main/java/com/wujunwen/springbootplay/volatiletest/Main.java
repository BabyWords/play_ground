package com.wujunwen.springbootplay.volatiletest;

public class Main {
    public static void main(String args[]){
        TestVolatile testVolatile=new TestVolatile();
        new Thread(){
            public void run(){
                testVolatile.changeStatus();
            }
        }.start();
        new Thread(){
            public void run(){
                testVolatile.run();
            }
        }.start();
    }
}
