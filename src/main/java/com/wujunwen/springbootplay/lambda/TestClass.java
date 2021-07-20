package com.wujunwen.springbootplay.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

  public static void main(String[] args) {
    TestClass testClass = new TestClass();
    testClass.test();

  }
  public void test(){
    List<Apple> inventory = new ArrayList();
    inventory.add(new Apple("white", 2));
    inventory.add(new Apple("red", 3));
    inventory.add(new Apple("white", 4));
    inventory.add(new Apple("red", 5));
    inventory.add(new Apple("white", 6));
    inventory.add(new Apple("red", 7));
    inventory.stream().takeWhile(apple -> apple.getWeight() < 3).forEach(System.out::println);
  }
}


