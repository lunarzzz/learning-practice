package com.example.demo.code.other;

import java.util.TreeMap;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-08 17:18
 **/
public class Solution25 {
    /**
     * Given this linked list: 1->2->3->4->5
     *
     * For k = 2, you should return: 2->1->4->3->5
     *
     * For k = 3, you should return: 3->2->1->4->5
     */

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode listNode1 = head;
        if (head == null){
            return head;
        }
        int count =0;
        ListNode last = head;
        while (last!=null){
            ++count;
            last = last.next;
        }
        if (count<k)
            return head;
        // node 为新表头
        ListNode node = reverse(head,k);
        ListNode node2 = reverseKGroup(last,k);
        head.next = node2;
        return node;
    }

    private static ListNode reverse(ListNode head, int k){
        if (head == null || head.next == null || k==1 || k==0)
            return head;
        ListNode s1 = head;
        ListNode s2 = head.next;
        ListNode s3 = s2.next;
        s2.next = s1;
        s1.next = null;
        // 2->1
        if (s3 == null){
            return s2;
        }
        // 1->2->3->4;
        ListNode reverse = reverse(s3, k - 1);
        s1.next = reverse;
        return s2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next =node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        TreeMap treeMap;
//        ListNode node = reverseKGroup(node1, 2);
        ListNode node = reverse(node1, 1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
