package com.example.demo.code.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassNameSolution189
 * @Description TODO
 * @Author apple
 * @Date 2018/9/2 1:13 PM
 * @Version 1.0
 */
public class Solution189 {
    /**
     *
     Given an array, rotate the array to the right by k steps, where k is non-negative.

     Example 1:

     Input: [1,2,3,4,5,6,7] and k = 3
     Output: [5,6,7,1,2,3,4]
     Explanation:
     rotate 1 steps to the right: [7,1,2,3,4,5,6]
     rotate 2 steps to the right: [6,7,1,2,3,4,5]
     rotate 3 steps to the right: [5,6,7,1,2,3,4]
     Example 2:

     Input: [-1,-100,3,99] and k = 2
     Output: [3,99,-1,-100]
     Explanation:
     rotate 1 steps to the right: [99,-1,-100,3]
     rotate 2 steps to the right: [3,99,-1,-100]
     */
//    public void rotate(int[] nums, int k) {
//        if (k<=0)
//            return;
//        int len = nums.length;
//        k = k % len;
//        int[] temp = new int[k];
//        // 存储数组前k个数备份
//        for (int i = 0; i < k; i++) {
//            temp[i] = nums[i];
//        }
//        for (int i = len-1; i >= k; i--) {
//            nums[(i+k)%len] = nums[i];
//        }
//        for (int i = k; i < 2*k; i++) {
//            nums[i] = temp[i-k];
//        }
//    }

    public void rotate(int[] nums, int k){
        if (k<0)
            return;
        k = k%nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k,nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    void reverse(int[] nums, int i, int j){
        for (int k = i; k <= (i+j)/2; k++) {
            int temp = nums[k];
            nums[k] = nums[j - k + i];
            nums[j - k + i] = temp;
        }
    }

    @Test
    public void test(){
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate(a, 10);
        System.out.println(Arrays.toString(a));
    }

}
