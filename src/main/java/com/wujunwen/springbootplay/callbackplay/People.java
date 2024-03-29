package com.wujunwen.springbootplay.callbackplay;

public class People {

    Printer printer = new Printer();

    /*
     * 同步回调
     */
    public void goToPrintSyn(Callback callback, String text) {
        //--3 直接打印 （同步）
        printer.print(callback, text);
    }

    /*
     * 异步回调
     */
    public void goToPrintASyn(Callback callback, String text) {
        //--3 新线程启动。传入回调函数 （异步）
        new Thread(() -> printer.print(callback, text)).start();
    }
}
