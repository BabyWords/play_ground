package com.wujunwen.springbootplay.callbackplay;

public class Printer {
    public void print(Callback callback, String text) {
        System.out.println(text);
        try {
            Thread.currentThread();
            Thread.sleep(3000);// 毫秒
        } catch (Exception e) {
        }
        //--4.执行回调函数
        callback.printFinished("打印完成");
    }
}