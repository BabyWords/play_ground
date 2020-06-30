package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Benatest {

    @Value("${test.value}")
    private String testvalue;

    @Bean
    public Person testPserson(){
        Person p = new Person();
        p.setAge(testvalue);
        return p;
    }
}
