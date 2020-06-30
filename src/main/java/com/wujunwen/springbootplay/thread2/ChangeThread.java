package com.wujunwen.springbootplay.thread2;

/**
 * @Author :wujunwen
 * @Description:
 * @Date: created in 15:46 2019/6/25
 * @Modified By:
 */
public class ChangeThread implements Runnable {

    TrueThread thread1;
    public  ChangeThread(TrueThread thread1){
        this.thread1 =thread1;
    }

    @Override
    public void run() {
        thread1.changecount();
    }
}
