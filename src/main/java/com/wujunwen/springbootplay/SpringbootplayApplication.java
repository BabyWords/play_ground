package com.wujunwen.springbootplay;

import com.wujunwen.springbootplay.annotation.Person;
import com.wujunwen.springbootplay.async.AsyncPlay;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootplayApplication {

    public static void main(String[] args) {
        Person person=new Person();
        person.getName();
    }
}
