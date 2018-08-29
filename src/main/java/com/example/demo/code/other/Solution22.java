package com.example.demo.code.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-08 10:03
 **/
public class Solution22 {
    /**
     * n==3
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<>();
        if (n==0){
            lists.add("");
        }
        else{
            for (int i = 0; i < n; ++i) {
                List<String> listsN1 = generateParenthesis(i);
                List<String> listsN2 = generateParenthesis(n-i-1);
                for (int j = 0; j < listsN1.size(); j++) {
                    for (int k = 0; k < listsN2.size(); k++) {
                        lists.add("("+listsN1.get(j)+")"+listsN2.get(k));
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.stream().forEach(System.out::println);
    }


}
