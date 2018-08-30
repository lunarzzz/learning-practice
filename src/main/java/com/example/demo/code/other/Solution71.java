package com.example.demo.code.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zhangjiawei
 * @create: 2018-08-30 10:44
 **/
public class Solution71 {
    /**
     *
     给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
     例如，
     path = "/home/", => "/home"
     path = "/a/./b/../../c/", => "/c"
     边界情况:
     你是否考虑了 路径 = "/../" 的情况？
     在这种情况下，你需返回 "/" 。
     此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
     在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        // 去除重复的/
//        Object[] collect = Stream.of(paths).filter(a -> !a.equals("") && !a.equals(".")).toArray();
        Set<String> skip = new HashSet<>(Arrays.asList(".","",".."));
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..") && !stack.empty())
                stack.pop();
            else if (!skip.contains(paths[i])){
                stack.push(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.empty())
            return "/";
        while (!stack.empty()) {
            sb.insert(0,"/" + stack.pop());
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String s = simplifyPath("/a/./b/../../c/");
        Assert.assertEquals("/c", s);
    }
}
