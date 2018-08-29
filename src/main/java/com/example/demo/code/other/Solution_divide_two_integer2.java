package com.example.demo.code.other;

import java.util.concurrent.ForkJoinPool;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-07 16:40
 **/
public class Solution_divide_two_integer2 {

    public static int divide(int dividend, int divisor) {
        long result =  divideLong(dividend,divisor);
        return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE:(int)result;
    }

    private static long divideLong(long divideend,long divisor){
        boolean flag = divideend <0 != divisor <0;

        long total=divisor;
        long divide = 1;
        if (divideend<0)
            divideend = -divideend;
        if (divisor<0)
            divisor = -divisor;
        if (divideend < divisor){
            return 0;
        }
        while ((total+total) <= divideend){
            total += total;
            divide += divide;
        }
        return flag ? -(divide + divideLong(divideend-total,divisor)):
                divide + divideLong(divideend-total,divisor);
    }



    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        int divide = divide(10, 3);
        System.out.println(divide);

    }

}
