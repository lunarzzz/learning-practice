package com.example.demo.monitor.config;

import com.example.demo.monitor.request.MonitorRepository;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: HTTP请求配置类
 * @author: zhangjiawei
 * @create: 2018-08-20 21:16
 **/
@Configuration
public class FeignConfig {

    @Bean
    public MonitorRepository monitorRepository(){
        MonitorRepository monitorRepository = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder()).options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(MonitorRepository.class, "http://api.nss.netease.com/api");
        return monitorRepository;
    }
}
