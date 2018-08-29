package com.example.demo.code.other;

import java.util.Arrays;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-13 15:50
 **/
public class Solution30_1 {

    /**
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int pos = 0;
        for (int i = nums.length - 1; i >0; i--) {
            if (nums[i] > nums[i - 1]) {pos = i; break;}
        }
        reverse(nums, pos, nums.length - 1);
        if (pos > 0) {
            int i = binarySearch(nums, nums[pos - 1], pos, nums.length - 1);
            swap(nums, pos - 1, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5};
        new Solution30_1().nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    
    
}
