package com.wujunwen.springbootplay.proxyplay.src.main.role;

import com.example.demo.service.Person;

public class Landlord implements Person {
    public void rent() {
        System.out.println("客官请进，我家的房子又大又便宜，来租我的吧...");
    }
}
