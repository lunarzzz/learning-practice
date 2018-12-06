package com.example.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassNamePropertiesReader
 * @Description TODO
 * @Author apple
 * @Date 2018/12/6 11:17 PM
 * @Version 1.0
 */
public class PropertiesReader {
    static Properties properties = new Properties();
    static {
        InputStream in = PropertiesReader.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(properties.getProperty("port"));
    }



}
