package com.example.demo.code.tree;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 16:55
 **/
public class Solution94 {

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return  res;
        if (root.left!=null)
            inorderTraversal(root.left);
        res.add(root.val);
        if (root.right!=null)
            inorderTraversal(root.right);
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        //循环实现中序遍历
        if (root == null)
            return res;TreeNode t = root;

        Stack<TreeNode> stack = new Stack();
        while (t!=null || !stack.empty()){
            while (t != null ) {
                res.add(t.val);
                stack.push(t);
                t = t.left;
            }
            if (!stack.empty())
            {
                t = stack.peek();
                stack.pop();
                t = t.right;
            }
        }
        return res;
    }
}
