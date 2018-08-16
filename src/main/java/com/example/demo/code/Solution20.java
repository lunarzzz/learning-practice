package com.example.demo.code;

import java.util.*;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-07 12:41
 **/
public class Solution20 {
    /**
     * valid brackets
     * @param s
     * @return
     */
    public static Map<String,String> maps= new HashMap<>();
    static {
        maps.put("]","[");
        maps.put("}","{");
        maps.put(")","(");
    }
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] split = s.split("");
        for (String s11 :
                split) {
            if (s11.equals("[") || s11.equals("{") || s11.equals("(")){
                queue.push(s11);
            }else{
                if (queue.isEmpty()){
                    return false;
                }else {
                    String pops = queue.pop();
                    if (!maps.get(s11).equals(pops))
                        return false;
                }
            }
        }
        if (queue.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean valid = isValid("{{{}}}");
        System.out.println(valid);
    }

}
