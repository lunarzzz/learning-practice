package com.example.demo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JiraTest {

    public Jira jira;
    @Before
    public void setUp() throws Exception {
        jira = new Jira();
    }

    @Test
    public void testJoinWithLineBreakIfEmpty() {
        String s = Jira.joinWithLineBreak(null, null, 1, null);
        System.out.println(s);
        Assert.assertNull(s);
    }

    @Test
    public void testJoinWith_1(){
        String s1 = Jira.joinWithLineBreak(Arrays.asList("1", "2", "3"), ",", 2, "-");
        Assert.assertEquals("1,2,-3",s1);
    }

    @Test
    public void testJoinWith_2(){
        String s1 = Jira.joinWithLineBreak(Arrays.asList("1", "2", "3","4"), ",", 2, "-");
        Assert.assertEquals("1,2,-3,4",s1);
    }

    @Test
    public void testJoinWith_3(){
        String s1 = Jira.joinWithLineBreak(Arrays.asList("1", "2", "3","4","5"), ",", 2, "-");
        Assert.assertEquals("1,2,-3,4,-5",s1);
    }
}