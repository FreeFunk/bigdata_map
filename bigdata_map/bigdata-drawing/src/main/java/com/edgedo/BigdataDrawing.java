package com.edgedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.edgedo")
@EnableScheduling
@EnableCaching
public class BigdataDrawing {
    public static void main(String[] args) {
        SpringApplication.run(BigdataDrawing.class, args);
    }
}
