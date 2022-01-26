package com.edgedo;

import com.edgedo.JT809.client.BPClient;
import com.edgedo.common.distance.DistanceCallSocketServer;
import com.edgedo.common.util.IocUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan("com.edgedo")
@EnableCaching
@EnableScheduling
public class Gps809ClientApp{
    public static void main(String[] args) {
        SpringApplication.run(Gps809ClientApp.class, args);
        try{
            BPClient client = new BPClient();
            BPClient.begin();
            client.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        DistanceCallSocketServer dcss = IocUtil.getBean(DistanceCallSocketServer.class);
        dcss.startListen();
    }
}
