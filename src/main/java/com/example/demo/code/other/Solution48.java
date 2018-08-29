package com.example.demo.code.other;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-23 20:15
 **/
public class Solution48 {

    /**
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     */
    public void rotate(int[][] matrix) {
        // rotate in place
        // a[1][1] -> a[1][3]
        // a[2][1] -> a[1][2]
        // a[3][1] -> a[1][1]
        // a[x][y] -> a[length-y][length-x]
        // 按层次来一次
        for (int i = 0; i < matrix.length; i++) {

        }
    }

}
