package com.example.demo.feature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Generic<T>{
    private static Logger log = LoggerFactory.getLogger(Generic.class);

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
    public void showKeyValue1(Generic<Number> obj){
        log.info("泛型测试,key value is " + obj.getKey());
    }
}