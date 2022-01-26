package com.edgedo.timetask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*@Component*/
public class Demo {

    @Scheduled(cron = "0/2 * * * * ?")
    public void test(){
        System.out.println("1111");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("222===================="+ Thread.currentThread().getName());
    }
}
