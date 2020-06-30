package com.wujunwen.springbootplay.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    Person person;
    @RequestMapping("/hello")
    public String test(){

        return person.getName();
    }
}
