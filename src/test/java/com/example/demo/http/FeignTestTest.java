package com.example.demo.http;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@Slf4j
public class FeignTestTest {

    @Autowired
    private FeignTest feignTest;

    @Test
    public void get() {
        User hello = feignTest.getHello();
        log.info(hello.toString());

//        assertEquals(user.getName(), "zhangjiawei");
    }

    @Test
    public void name() {
        User hahahaaha = feignTest.getHello1(new User("hahahaaha", 111));
        log.info(hahahaaha.toString());
        log.info(hahahaaha.getClass().getName());
//        assertEquals(hahahaaha.getName(), "zhangjiawei1");
    }

    @Test
    public void tstPost() {
        User zhangjaiwe = feignTest.getHello2("zhangjaiwe", 12);
        log.info(zhangjaiwe.toString());
        log.info(zhangjaiwe.getClass().getName());
    }

    @Test
    public void testPramGet(){
        User zhangjiaweiqwe_qwe_ = feignTest.getHello3("zhangjiaweiqweqwe ", "qwe");
        log.info(zhangjiaweiqwe_qwe_.toString());
    }

    @Test
    public void namePaReapGet() {
        MonitorDTO monitorDTO = feignTest.getHello5("dajaihao ", "asdasdasdasdasd");
        log.info(monitorDTO.toString());
    }

    @Test
    public void name5555() {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("client", "zhangjiaweiAPPPPPPP");
        paramMap.put("signature", "i am the signature");
        User hello5555 = feignTest.getHello5555(paramMap);
        log.info(hello5555.toString());
    }

    @Test
    public void test(){
        log.info("123");
        log.info("456");
        IntStream.rangeClosed(1, 100).forEach(a -> {
            log.info("zhangjiawei");
            log.info("helloworld");
        });
    }

}