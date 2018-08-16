package com.example.demo.code;

/**
 * @description:
 * @author: zhangjiawei
 * @create: 2018-08-08 13:47
 **/
public class Solution23 {

    /**
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //
        if (lists == null || lists.length == 0){
            return null;
        }
        int count = 0;
        ListNode head = new ListNode(0);
        for (int i=0;i<lists.length;++i
        ){
            if (lists[i] != null){
                count = i;
                head = lists[i];
            }
        }
        for (int i=0;i<lists.length;++i
             ) {
            if (lists[i] == null){
                continue;
            }
            if (lists[i].val<head.val){
                head = lists[i];
                count = i;
            }
        }
        if (lists[count] != null){
            lists[count] = lists[count].next;
            head.next = mergeKLists(lists);
        }else{
            head = null;
        }
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

