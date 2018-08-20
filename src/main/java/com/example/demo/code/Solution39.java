package com.example.demo.code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-13 19:28
 **/
public class Solution39 {
    /**
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, ArrayList<Integer> list, int[] candidates, int remain, int start) {
        if (remain < 0)
            return ;
        if (remain == 0){
            lists.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);

            dfs(lists, list, candidates, remain-candidates[i], i);

            list.remove(list.size()-1);
        }
    }
}
