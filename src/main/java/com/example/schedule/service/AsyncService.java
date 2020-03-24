package com.example.schedule.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理中...");
    }
    @Scheduled(cron = "* * * * * 0-7")
    public void hi(){
        System.out.println("你好");
    }

}
