package com.edgedo.config;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Test {

    //定时任务demo
    /*@Scheduled(cron = "0/2 * * * * ?")
    public  void test(){
        System.out.println(new Date());
    }*/
}

