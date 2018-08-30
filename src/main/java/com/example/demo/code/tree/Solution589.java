package com.example.demo.code.tree;

import lombok.val;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 17:50
 **/
public class Solution589 {
    List<Integer> res = new ArrayList<>();

    // 递归
    public List<Integer> preorder(Node root) {
        if(root ==null)
            return res;
        res.add(root.val);
        if(root.children != null)
            root.children.forEach(a -> preorder(a));
        return res;
    }

    // 迭代法
    public List<Integer> preorder2(Node root) {
        Stack<Node> stack = new Stack();
        if(root ==null)
            return res;
        stack.push(root);
        while (!stack.empty()){
            Node a = stack.pop();
            res.add(a.val);
            if (a.children!=null){
                // 需要使得最左边结点在栈顶
                Collections.reverse(a.children);
                a.children.forEach(b -> stack.push(b));
            }
        }
        return res;
    }

    @Test
    public void test(){

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
