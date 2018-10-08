package com.example.demo.code.other;

import java.util.Arrays;

/**
 * @ClassNameSolution75
 * @Description TODO
 * @Author apple
 * @Date 2018/10/7 9:17 PM
 * @Version 1.0
 */
public class Solution75 {
    public static void sortColors(int[] nums) {
        // 常数空间的一趟扫描算法
        int n0 = 0,n1 = 0;
        for(int i=0;i< nums.length;++i){
            if(nums[i] == 0) n0++;
            if(nums[i] == 1) n1++;
            // if(nums[i] == 2) n2++;
        };
        // 常数空间会产生覆盖问题
        int a[] = new int[nums.length];
        int count0=0,count1=n0,count2=n1+n0;
        for(int i=0;i< nums.length;++i){
            if(nums[i] == 0) {
                a[count0++] = 0;
            } else if(nums[i] == 1) {
                a[count1++] = 1;
            } else
                a[count2++] = 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
//        nums = a;
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        sortColors(new int[] {0,1,2,0,1,2});
    }
}