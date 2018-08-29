package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-29 09:49
 **/
public class Solution64 {
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m+1][n+1];
        res[1][1] = grid[0][0];
        int s =0;
        while (s<=m){
            res[s][0] = Integer.MAX_VALUE;
            s++;
        }
        int r =0;
        while (r<=n){
            res[0][r] = Integer.MAX_VALUE;
            r++;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1 && i == 1)
                    continue;
                res[i][j] =grid[i-1][j-1] + Math.min(res[i][j-1], res[i-1][j]);
            }
        }

        return res[m][n];
    }


    @Test
    public void test(){
        int[][] a = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int i = minPathSum(a);
        Assert.assertEquals(7, i);
    }



}
