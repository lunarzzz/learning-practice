package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 10:26
 **/
public class Solution66 {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i] + 1 < 10){
                digits[i]++;
                flag = false;
                break;
            }else {
                digits[i] = 0;
                flag = true;
            }
        }
        if (flag){
            int [] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }

    @Test
    public void test(){
        int[] ints = plusOne(new int[]{4, 3, 2, 1});
//        Assert.assertEquals(Arrays.asList(ints), Arrays.asList(new int[]{4,3,2,2}));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void test_2(){
        int[] ints = plusOne(new int[]{9, 9, 9, 9});
//        Assert.assertEquals(Arrays.asList(ints), Arrays.asList(new int[]{4,3,2,2}));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
