package com.wujunwen.springbootplay.aop;

public class Talker implements Talk {
    @Override
    public void talk(String msg) {
        System.out.println("我是本体"+"...."+msg);
        throw new NullPointerException();
    }
}
