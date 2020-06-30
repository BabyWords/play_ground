package com.wujunwen.springbootplay.aop;

public class TalkerProxy implements Talk{
    private Talker talker;
    @Override
    public void talk(String msg) {
        talker.talk(msg);
        System.out.println("代理talk...."+msg);
    }

    public TalkerProxy(Talker talker){
        this.talker=talker;
    }
}
