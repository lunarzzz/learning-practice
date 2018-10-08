package com.example.demo.code.linkedlist;

import org.junit.Test;

/**
 * @ClassNameSolution142
 * @Description TODO
 * @Author apple
 * @Date 2018/9/2 6:55 PM
 * @Version 1.0
 */
public class Solution142 {
   // Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
   public ListNode detectCycle(ListNode head) {
       if (head == null)
           return null;
       ListNode slow = head;
       ListNode fast = head;
       boolean flag = false;
       while (slow.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
           if (slow == fast){
               flag = true;
               break;
           }
       }
       if (flag == false)
           return null;
       slow = head;
       while (slow != fast){
           slow = slow.next;
           fast = fast.next;
       }
       return slow;
   }


   @Test
    public void test(){
       // 1->2->3->4
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(15);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
       ListNode listNode = detectCycle(l1);
       System.out.println(listNode.val);

   }

}
