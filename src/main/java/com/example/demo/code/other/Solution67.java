package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 10:40
 **/
public class Solution67 {
    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int lena = a.length();
        int lenb = b.length();
        boolean flag = false;
        int minl = Math.min(lena,lenb);
        int i;
        for (i = 1; i <= minl; i++) {
            if (a.charAt(lena-i) == '1' && b.charAt(lenb-i) == '1'){
                if (flag == true){
                    s.insert(0,'1');
                }else {
                    s.insert(0,'0');
                }
                flag = true;
            }else if (a.charAt(lena-i) == '1' || b.charAt(lenb-i) == '1'){
                if (flag == true){
                    s.insert(0,'0');
                }else {
                    s.insert(0,'1');
                    flag = false;
                }
            }else {
                if (flag == true){
                    s.insert(0,'1');
                    flag = false;
                }else
                    s.insert(0,'0');
            }
        }
        if ( i-1 == lena){
            while(i-1 < lenb){
                if (flag == true){
                    if (b.charAt(lenb - i) == '0'){
                        s.insert(0,'1');
                        flag = false;
                    }else {
                        s.insert(0,'0');
                    }
                }else{
                    s.insert(0,b.charAt(lenb - i));
                }
                i++;
            }
        }else {
            while(i-1 < lena){
                if (flag == true){
                    if (a.charAt(lena - i) == '0'){
                        s.insert(0,'1');
                        flag = false;
                    }else {
                        s.insert(0,'0');
                    }
                }else{
                    s.insert(0,a.charAt(lenb - i));
                }
                i++;
            }
        }
        if (flag == true){
            s.insert(0,'1');
        }
        return s.toString();
    }

    @Test
    public void test(){
        String s = addBinary("1010", "1011");
        Assert.assertEquals("10101", s);
    }

    @Test
    public void test_2(){
        String s = addBinary("11", "1");
        Assert.assertEquals("100", s);
    }

    @Test
    public void test_3(){
        String s = addBinary("100", "110010");
        Assert.assertEquals("110110", s);
    }

}
