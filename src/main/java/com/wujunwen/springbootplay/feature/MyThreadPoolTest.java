package com.wujunwen.springbootplay.feature;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolTest {

    public static void main(String args[]){
        TestRunnable testRunnable = new TestRunnable();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(testRunnable);

    }
}
