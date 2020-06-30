package com.wujunwen.springbootplay.generic;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);
        for (int i = 0; i < list.size(); i++) {

            System.out.println("name:" + list.get(i));
        }
    }
}
