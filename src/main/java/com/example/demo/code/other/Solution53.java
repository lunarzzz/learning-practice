package com.example.demo.code.other;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-24 16:20
 **/
public class Solution53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
     public static int maxSubArray(int[] nums) {
        int maxSofa = nums[0];
        int maxHare = nums[0];
        // 当前最大值
         for (int i = 1; i < nums.length; i++) {//
//           // maxsofa 目前最长的连续子数组之和
//             // 包含当前位置的maxHare当前的连续
             maxHare = Math.max(maxHare+nums[i],nums[i]);
             maxSofa = Math.max(maxSofa,maxHare);
         }
         return maxSofa;
     }

    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);

    }

}
