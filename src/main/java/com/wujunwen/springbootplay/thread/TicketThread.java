package com.wujunwen.springbootplay.thread;

public class TicketThread extends Thread{
    private  int ticket = 100;

    public void run(){

            synchronized (this){
                for(int i =0;i<5;i++){
                if(this.ticket>0){
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName()+"i,="+i+"卖票---->"+(this.ticket--));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] arg){
        TicketThread t1 = new TicketThread();
        new Thread(t1,"线程1").start();
        new Thread(t1,"线程2").start();
    }
}
