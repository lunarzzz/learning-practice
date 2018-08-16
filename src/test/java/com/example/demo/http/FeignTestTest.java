package com.example.demo.http;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FeignTestTest {

    @Autowired
    private FeignTest feignTest;

    @Test
    public void get() {
        Object hello = feignTest.getHello();
        log.info(hello.toString());

//        assertEquals(user.getName(), "zhangjiawei");
    }

    @Test
    public void name() {
        Object hahahaaha = feignTest.getHello1(new User("hahahaaha", 111));
        log.info(hahahaaha.toString());
        log.info(hahahaaha.getClass().getName());
//        assertEquals(hahahaaha.getName(), "zhangjiawei1");
    }

    @Test
    public void tstPost() {
        Object zhangjaiwe = feignTest.getHello2("zhangjaiwe", 12);
        log.info(zhangjaiwe.toString());
        log.info(zhangjaiwe.getClass().getName());
    }

    @Test
    public void testPramGet(){
        Object zhangjiaweiqwe_qwe_ = feignTest.getHello3("zhangjiaweiqweqwe ", "qwe");
        log.info(zhangjiaweiqwe_qwe_.toString());
    }


}