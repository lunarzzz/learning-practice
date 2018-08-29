package com.example.demo.code.other;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-07 09:51
 **/
public class Solution {
    // abc    bc    -->2
    // 第一次出现的位置
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0){
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i < len1-len2; i++) {
            int k = i;
            int start = 0;
            while (start<len2 && k<len1){
                if (needle.charAt(start) == haystack.charAt(k)){
                    k++;
                    start++;
                }else {
                    break;
                }
            }
            if (start == len2){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaa","aaaa"));
    }
}
