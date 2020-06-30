package com.wujunwen.springbootplay.aop;

public class Main2 {
    public static void main(String args[]){
        Talk talk = (Talk) new DynamicProxy().bind(new Talker());
        talk.talk("haha");
    }
}
