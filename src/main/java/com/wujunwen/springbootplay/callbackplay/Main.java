package com.wujunwen.springbootplay.callbackplay;

/**
 * 总结：
 * 1.定义回调行为
 * 2.传入回调行为
 * 3.执行完成后回调
 */
public class Main {//测试类，同步回调
    public static void main(String[] args) {
        People people = new People();

        //这里是匿名内部类,并不是接口实例化
        //--1. 定义回调函数
        Callback callback = msg -> System.out.println("打印机告诉我的消息是 ---> " + msg);
        //--2. 异步调用
        people.goToPrintSyn(callback, "打印一份简历");
        //--5 .观察该步骤的执行顺序。
        System.out.println("我在等待 打印机 给我反馈");
    }
}