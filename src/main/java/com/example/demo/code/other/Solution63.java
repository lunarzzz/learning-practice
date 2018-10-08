package com.example.demo.code.other;

import org.junit.Test;

/**
 * @ClassNameSolution63
 * @Description TODO
 * @Author apple
 * @Date 2018/8/29 1:38 AM
 * @Version 1.0
 */
public class Solution63 {
    /**
     * 输入:
     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     输出: 2
     解释:
     3x3 网格的正中间有一个障碍物。
     从左上角到右下角一共有 2 条不同的路径：
     1. 向右 -> 向右 -> 向下 -> 向下
     2. 向下 -> 向下 -> 向右 -> 向右
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] temp = new int[m+1][n+1];
        temp[1][1] = 1;
        for (int j = 1; j < m+1; j++) {
            for (int k = 1; k < n+1; k++) {
                if (j == 1 && k == 1)
                    continue;
                if (obstacleGrid[j-1][k-1] == 1){
                    temp[j][k] = 0;
                }else {
                    temp[j][k] = temp[j - 1][k] + temp[j][k - 1];
                }
            }
        }
        return temp[m][n];
    }

    @Test
    public void test(){
        int a[][] = {
            {0,0,0},{0,1,0},{0,0,0}
        };
        int i = uniquePathsWithObstacles(a);
        System.out.println(i);
    }
}
