package com.example.demo.code.other;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 10:30
 **/
public class Solution41 {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * [1,2,3,4,6]  -> 5
     */
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        // 记录最小数，第一个不连续的最小数
        int secondMin = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
//            if ()
        }
        return 0;
    }
}
