package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassNameSolution34
 * @Description TODO
 * @Author apple
 * @Date 2018/9/2 12:21 PM
 * @Version 1.0
 */
public class Solution34 {
    /**
     *
     给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

     你的算法时间复杂度必须是 O(log n) 级别。

     如果数组中不存在目标值，返回 [-1, -1]。

     示例 1:

     输入: nums = [5,7,7,8,8,10], target = 8
     输出: [3,4]
     示例 2:

     输入: nums = [5,7,7,8,8,10], target = 6
     输出: [-1,-1]
     */
    int[] res = new int[2];

    public int[] searchRange(int[] nums, int target) {
        res[0] = nums.length;
        res[1] = -1;
        searchRange(nums, target, 0, nums.length-1);
        if (res[0] == nums.length)
            res[0] = -1;
        return res;
    }

    void searchRange(int[] nums, int tartget, int i, int j){
        if (i>j)
            return;
        int mid = (i + j)>>1;
        if (nums[mid] == tartget){
            res[0] = Math.min(mid, res[0]);
            res[1] = Math.max(mid, res[1]);
            searchRange(nums, tartget, i, mid-1);
            searchRange(nums, tartget, mid+1, j);
        }else if (nums[mid] < tartget){
            searchRange(nums, tartget, mid+1, j);
        }else
            searchRange(nums, tartget, i, mid-1);
    }

    @Test
    public void test(){
        int a[] = new int[]{5,7,7,8,8,10};
        searchRange(a, 8);
        System.out.println(Arrays.toString(res));
        Assert.assertEquals(3, res[0]);
        Assert.assertEquals(4, res[1]);
    }

    @Test
    public void test_1(){
        int a[] = new int[]{5,7,7,8,8,10};
        searchRange(a, 6);
        System.out.println(Arrays.toString(res));
        Assert.assertEquals(-1, res[0]);
        Assert.assertEquals(-1, res[1]);
    }

}


