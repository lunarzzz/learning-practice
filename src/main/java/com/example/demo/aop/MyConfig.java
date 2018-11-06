package com.example.demo.aop;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 1@ClassNameMyConfig
 * @Description TODO
 * @Author apple
 * @Date 2018/11/4 9:41 PM
 * @Version 1.0
 */
@Configuration
public class MyConfig implements BeanPostProcessor{

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        user();
        System.out.println("init");
    }

    public MyConfig() {
        System.out.println("construct");
    }

    public Object postProcessAfterInitialization(Object object, String name) {
//        System.out.println("123");
        return object;
    }

    @Bean
    public User user() {
        return new User();
    }
}
