package com.example.demo.code;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-08 17:10
 **/
public class Solution24 {

    /**
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode s1 = head;
        ListNode s2 = head.next;
        ListNode last = s2.next;
        s2.next = s1;
        s1.next = swapPairs(last);
        return s2;
    }
}
