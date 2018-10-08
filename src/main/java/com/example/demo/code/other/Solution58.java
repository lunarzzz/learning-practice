package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassNameSolution58
 * @Description TODO
 * @Author apple
 * @Date 2018/8/28 11:15 PM
 * @Version 1.0
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        String s1 = s.trim();
        if (s1.length() == 0)
            return 0;
        String[] ss = s1.split(" ");
        return ss[ss.length-1].length();
    }

    @Test
    public void test(){
        int i = lengthOfLastWord("  ");
        Assert.assertEquals(0,i);
    }
}
