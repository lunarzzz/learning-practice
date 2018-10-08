package com.example.demo.code.other;

/**
 * @ClassNameSolution61
 * @Description TODO
 * @Author apple
 * @Date 2018/8/29 12:53 AM
 * @Version 1.0
 */
public class Solution61 {
    /**
     *
     给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     示例 1:
     输入: 1->2->3->4->5->NULL, k = 2
     输出: 4->5->1->2->3->NULL
     解释:
     向右旋转 1 步: 5->1->2->3->4->NULL
     向右旋转 2 步: 4->5->1->2->3->NULL
     示例 2:
     输入: 0->1->2->NULL, k = 4
     输出: 2->0->1->NULL
     解释:
     向右旋转 1 步: 2->0->1->NULL
     向右旋转 2 步: 1->2->0->NULL
     向右旋转 3 步: 0->1->2->NULL
     向右旋转 4 步: 2->0->1->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        //
        if (head == null || head.next == null)
            return head;
        int len = 0;
        ListNode s = head;
        while (s.next != null){
            len++;
            s = s.next;
        }
        int real = k % len;
        // 找到倒数第k个节点 和最后一个节点
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < real){
            fast = fast.next;
            i++;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next =null;
        return head;
    }
}
