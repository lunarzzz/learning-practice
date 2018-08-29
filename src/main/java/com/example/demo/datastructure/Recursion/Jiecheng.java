package com.example.demo.datastructure.Recursion;

import org.junit.Assert;
import org.junit.Test;

import javax.management.ListenerNotFoundException;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 14:16
 **/
public class Jiecheng {

    int getJiecheng(int n){
        if (n == 1)
            return 1;
        else if (n == 0)
            return 1;
        else
            return getJiecheng(n-1) * n;
    }

    @Test
    public void test(){
        Assert.assertEquals(24, getJiecheng(4));
    }

    @Test
    public void test_2(){
        Assert.assertEquals(120, getJiecheng(5));
    }
}
