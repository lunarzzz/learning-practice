package com.example.demo.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-13 17:43
 **/
public class Solution36 {


    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        for (int i = 0; i < 9; i = i+3) {
            for (int j = 0; j < 9; j = j+3) {
                if (!isValidThree(board, i, j)){
                    flag = false;
                }
            }
        }
        if (!flag)
            return false;
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board,i) | !isValidVolumn(board,i)){
                flag = false;
            }
        }
        return flag;
    }

    private boolean isValidThree(char[][] board,int ii,int jj){
        Set<Character> characterSet = new HashSet<>();
        for (int i = ii; i < ii+3; i++) {
            for (int j = jj; j < jj+3; j++) {
                if (board[i][j] != '.'){
                    if (characterSet.contains(board[i][j])){
                        return false;
                    }else
                        characterSet.add(board[i][j]);
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] b,int row){
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (b[row][i] != '.'){
                if (characterSet.contains(b[row][i])){
                    return false;
                }else
                    characterSet.add(b[row][i]);
            }
        }
        return true;
    }

    private boolean isValidVolumn(char[][] b,int val){
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (b[i][val] != '.'){
                if (characterSet.contains(b[i][val])){
                    return false;
                }else
                    characterSet.add(b[i][val]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char [][] c = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        };
        boolean validSudoku = new Solution36().isValidSudoku(c);
        System.out.println(validSudoku);
    }



}
