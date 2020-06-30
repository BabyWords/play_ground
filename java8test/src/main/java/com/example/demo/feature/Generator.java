package com.example.demo.feature;

//定义一个泛型接口
public interface Generator<T> {
    public T next();
}