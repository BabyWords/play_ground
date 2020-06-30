package com.wujunwen.springbootplay.thread2;

/**
 * @Author :wujunwen
 * @Description:
 * @Date: created in 15:49 2019/6/25
 * @Modified By:
 */
public class Main {
    public static void main(String args[]) {
        TrueThread trueThread = new TrueThread();
        ChangeThread changeThread = new ChangeThread(trueThread);

        Thread Mthread1 = new Thread(trueThread);
        Thread Mthread2 = new Thread(changeThread);

        Mthread1.start();
        Mthread2.start();


    }
}
