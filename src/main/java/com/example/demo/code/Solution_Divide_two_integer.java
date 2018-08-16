package com.example.demo.code;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-07 13:47
 **/
public class Solution_Divide_two_integer {

    public static int divide(int dividend, int divisor) {
        // 不使用乘除%
        if (dividend == 0 || divisor == 0)
            return 0;
        boolean flag = false;
        // false - |   true +
        if (dividend == Integer.MAX_VALUE){
            if (divisor == 1 || divisor== -1)
            return divisor==1?Integer.MAX_VALUE:-Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1 || divisor== -1)
            return divisor==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        if (dividend<0){
            dividend = -dividend;
            if (divisor<0){
                flag = true;
                divisor = -divisor;
            }
        }else{
            if (divisor>0)
                flag = true;
            else
            divisor = -divisor;
        }

        int res = 1;
        int total = divisor;
        long count = dividend;
        while (total <= count){
            total += divisor;
            res++;
        }
        if (false == flag)
            return -(res-1);
        return res-1;
    }

    public static void main(String[] args) {
        System.out.println(divide(-1,-1));
    }
}
