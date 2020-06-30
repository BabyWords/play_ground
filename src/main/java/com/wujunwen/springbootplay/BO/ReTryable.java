package com.wujunwen.springbootplay.BO;

public @interface ReTryable {
     Class<? extends ExceptionHandler> handler() default ConnectExceptionHandler.class;
     Class<? extends Exception> retryBy();
     int reTryTime();
}
