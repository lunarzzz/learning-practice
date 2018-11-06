package com.example.demo.testabstract;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired
    Base1 base1;

    @Autowired
    Base2 base2;

    @Test
    public void getA() {
        System.out.println(base1.getA());
        System.out.println(base2.getA());
    }
}