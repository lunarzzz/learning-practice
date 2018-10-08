package com.example.demo.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.http.HttpClient;


import java.io.IOException;
import java.net.URL;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-15 16:47
 **/
public class RedisTest {

    Logger logger = LoggerFactory.getLogger(RedisTest.class);
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClient.New(new URL("http://www.baidu.com"));
        boolean keepingAlive = httpClient.isKeepingAlive();
        System.out.println(keepingAlive);
    }
}
