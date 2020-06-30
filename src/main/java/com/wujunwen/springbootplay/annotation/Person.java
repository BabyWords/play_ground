package com.wujunwen.springbootplay.annotation;

import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    @PersonAnnotation(name = "吴俊文")
    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name;
    }


}
