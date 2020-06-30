package com.wujunwen.springbootplay.thread;

public class RunnablePlay {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyThread2 m=new MyThread2();
        new Thread(m).start();
        new Thread(m).start();

    }

}
class MyThread2 implements Runnable{
    private int ticket = 5;
    @Override
    public void run(){
        while(true){
            System.out.println("Runnable ticket = " + ticket--);
            if(ticket < 0){
                break;
            }
        }
    }
}