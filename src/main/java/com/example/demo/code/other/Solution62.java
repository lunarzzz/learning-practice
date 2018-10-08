package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassNameSolution62
 * @Description TODO
 * @Author apple
 * @Date 2018/8/29 1:18 AM
 * @Version 1.0
 */
public class Solution62 {
//    public int uniquePaths(int m, int n) {
//        if (n == 1 || m == 1)
//            return 1;
//        return uniquePaths(m-1,n) + uniquePaths(m, n-1);
//    }

    /**
     * f(m,n) = f(m-1,n) + f(m, n-1)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int [][] temp = new int[m][n];
        int i = 0;
        while (i< n){
            temp[0][i] = 1;
            i++;
        }
        i = 0;
        while (i< m){
            temp[i][0] = 1;
            i++;
        }
        for (int j = 1; j < m; j++) {
            for (int k = 1; k < n; k++) {
                temp[j][k] = temp[j-1][k] + temp[j][k-1];
            }
        }
        return temp[m-1][n-1];
    }

    @Test
    public void test(){
        int i = uniquePaths(7, 3);
        Assert.assertEquals(28, i);
    }
}
