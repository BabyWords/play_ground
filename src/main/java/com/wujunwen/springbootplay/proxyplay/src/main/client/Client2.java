package com.wujunwen.springbootplay.proxyplay.src.main.client;

import com.example.demo.handler.RentHandler;
import com.example.demo.role.Landlord;
import com.example.demo.service.Person;

import java.lang.reflect.Proxy;

public class Client2 {
    public static void main(String[] args) {
        Person landlord = new Landlord();
        Person proxy = (Person) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), //加载代理类的类加载器
                new Class[]{Person.class}, //代理的接口
                new RentHandler(landlord));//自定义调用处理器实现
        proxy.rent();
    }

}
