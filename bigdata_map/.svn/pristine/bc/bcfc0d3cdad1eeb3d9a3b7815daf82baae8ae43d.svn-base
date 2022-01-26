package com.edgedo.config;

import com.edgedo.common.util.BaiDuMapApiUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/util.yml")
public class UtilConfig {
    @Value("${baidu.baidu_geocoder_ak}")
    String geocoderAk;

    @Bean
    public BaiDuMapApiUtil baiDuMapApiUtil(){
        BaiDuMapApiUtil bdmau = new BaiDuMapApiUtil(geocoderAk);
        return bdmau;
    }
}
