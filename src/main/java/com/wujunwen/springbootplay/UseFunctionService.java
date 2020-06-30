package com.wujunwen.springbootplay;

public class UseFunctionService {

    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService){
        this.functionService=functionService;
    }

    public String say(){
        return functionService.sayHello();
    }
}
