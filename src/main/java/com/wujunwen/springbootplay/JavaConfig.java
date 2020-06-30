package com.wujunwen.springbootplay;

import com.wujunwen.springbootplay.async.AsyncPlay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService=new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }


    @Bean
    public AsyncPlay asyncPlay(){
        return new AsyncPlay();
    }
}
