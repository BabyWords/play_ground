package com.wujunwen.springbootplay.callbackplay;

public class Main {//测试类，同步回调
    public static void main(String[] args) {
        People people = new People();

        //这里是匿名内部类,并不是接口实例化
        Callback callback = new Callback() {
            @Override
            public void printFinished(String msg) {
                System.out.println("打印机告诉我的消息是 ---> " + msg);
            }
        };
        people.goToPrintASyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机 给我反馈");
    }
}