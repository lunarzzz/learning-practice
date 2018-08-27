package com.example.demo.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 15:54
 **/
public class Solution47 {
    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     *
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        // sort
        //
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //
        boolean[] used = new boolean[nums.length];
        permuteUniqueres(res, temp, nums, used);


        return res;
    }

    void permuteUniqueres(List<List<Integer>> res, List<Integer> temp,int[] nums, boolean[] used){
        // dfs
        //
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }
        int prev = nums[0] -1;
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false && nums[i] != prev){
                temp.add(nums[i]);
                used[i] = true;
                prev = nums[i];
                permuteUniqueres(res, temp, nums, used);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }
}
