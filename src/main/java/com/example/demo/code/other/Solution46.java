package com.example.demo.code.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 10:49
 **/
public class Solution46 {

    /**
     *
     给定一个没有重复数字的序列，返回其所有可能的全排列。
     输入: [1,2,3]
     输出:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]
     */
    // TODO 回溯 subSet
    public List<List<Integer>> subSet(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();
        backTrace(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backTrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int i) {
        lists.add(new ArrayList<>(list));

        for (int j = i; j < nums.length; j++) {
            list.add(nums[i]);
            backTrace(lists, list, nums, j+1);
            list.remove(list.size()-1);
        }
    }

    // permutation
    //
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        backTracePer(lists, new ArrayList<>(), nums);
        return lists;
    }

    private void backTracePer(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
        }else{
            // j从哪里开始呢？ 取决于你下一次需要遍历的位置
            for (int j = 0; j < nums.length; j++) {
                if (list.contains(nums[j]))
                    continue;
                list.add(nums[j]);
                backTracePer(lists, list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
