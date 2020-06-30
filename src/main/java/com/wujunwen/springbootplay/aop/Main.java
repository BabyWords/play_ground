package com.wujunwen.springbootplay.aop;

public class Main {
    public static void main(String args[]){
        Talker talker=new Talker();
        TalkerProxy talkerProxy = new TalkerProxy(talker);
        talkerProxy.talk("???");
    }
}
