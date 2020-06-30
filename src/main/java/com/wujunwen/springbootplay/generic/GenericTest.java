package com.wujunwen.springbootplay.generic;

public class GenericTest {

    public static void main(String[] args) {
        Box<Number> name = new Box<Number>(99);
        Box<Integer> age = new Box<Integer>(712);
        getData(name);

    }

    public static void getData(Box<Number> data){
        System.out.println("data :" + data.getData());
    }
}


class Box<T> {
    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}