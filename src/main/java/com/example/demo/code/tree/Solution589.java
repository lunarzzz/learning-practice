package com.example.demo.code.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 17:50
 **/
public class Solution589 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root ==null)
            return res;
        if (root.children!=null){
            res.add(root.val);
        }
        root.children.stream().forEach(a -> preorder(a));
        return res;
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
