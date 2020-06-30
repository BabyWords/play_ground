package com.wujunwen.springbootplay.event;

import org.springframework.context.ApplicationListener;

public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg=demoEvent.getMsg();
        System.out.println("receive message");
    }
}
