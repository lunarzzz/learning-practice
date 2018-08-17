package com.example.demo.http;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-16 14:09
 **/
@Configuration
public class FeignTestConfig {

    @Bean
    public FeignTest feignTest(){
        FeignTest feignTest = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder()).options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(FeignTest.class, "http://localhost:8888");
        return feignTest;
    }


}
