package com.wujunwen.springbootplay.thread;

public class ThreadPlay {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MyThread().start();
        new MyThread().start();

    }


}

class MyThread extends Thread {
    private int ticket = 5;
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread ticket = " + ticket--);
            if(ticket < 0){
                break;
            }
        }
    }
}
