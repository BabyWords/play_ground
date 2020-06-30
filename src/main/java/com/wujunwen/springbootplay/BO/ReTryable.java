package com.wujunwen.springbootplay.BO;

public @com.example.demo.interface ReTryable {
     Class<? extends ExceptionHandler> handler() default ConnectExceptionHandler.class;
     Class<? extends Exception> retryBy();
     int reTryTime();
}
