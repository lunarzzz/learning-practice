package com.example.demo.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNameMyCorecct
 * @Description TODO
 * @Author apple
 * @Date 2018/11/4 10:20 PM
 * @Version 1.0
 */
@Configuration
public class MyCorecct implements BeanPostProcessor{
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(1234);
        return bean;
    }
}
