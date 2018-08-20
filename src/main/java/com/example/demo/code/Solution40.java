package com.example.demo.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-17 10:06
 **/
public class Solution40 {

    /**
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        dfs(lists, list, candidates, target, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int i) {
        if (target<0)
            return;
        if (target == 0)
            lists.add(new ArrayList<>(list));
        for (int j = i; j < candidates.length; j++) {
            list.add(candidates[j]);
            // j+1 从下一个数开始
            // 去重
            if (j > i && candidates[j] == candidates[j-1])
                continue;
            list.add(candidates[j]);
            dfs(lists, list, candidates, target-candidates[j], j+1);
            list.remove(list.size()-1);
        }
    }
}
