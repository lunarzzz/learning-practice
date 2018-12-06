package com.example.demo.config;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @ClassNamePortPropertyDefiner
 * @Description TODO
 * @Author apple
 * @Date 2018/12/6 11:13 PM
 * @Version 1.0
 */
public class PortPropertyDefiner extends PropertyDefinerBase{
    @Override
    public String getPropertyValue() {
        return PropertiesReader.properties.getProperty("port");
    }
}
