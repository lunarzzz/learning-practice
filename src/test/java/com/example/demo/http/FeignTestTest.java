package com.example.demo.http;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignTestTest {

    Logger log = LoggerFactory.getLogger(FeignTestTest.class);
    @Test
    public void test(){
        log.info("123");
        log.info("456");
        IntStream.rangeClosed(1, 2).forEach(a -> {
            log.info("zhangjiawei");
            log.info("helloworld");
        });
//        System.out.println(System.getenv());
    }

//    static {
//        System.setProperty("splunk.port", "8001");
////        System.out.println(${splunk.port});
//    }

}