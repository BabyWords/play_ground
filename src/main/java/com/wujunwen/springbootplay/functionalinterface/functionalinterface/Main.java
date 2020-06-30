package com.wujunwen.springbootplay.functionalinterface.functionalinterface;

public class Main {
    public static void main(String args[]) {
        MyfunInterface ss= (a,b) -> {
            return a + b;
        };

        System.out.println(ss.getsum(1, 2));


    }
}
