package com.example.demo.config;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.PropertyDefinerBase;
import ch.qos.logback.core.spi.PropertyDefiner;
import ch.qos.logback.core.status.Status;

/**
 * @ClassNameLogPropertyDefiner
 * @Description TODO
 * @Author apple
 * @Date 2018/12/6 10:59 PM
 * @Version 1.0
 */
public class LogPropertyDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return PropertiesReader.properties.getProperty("host");
    }
}
