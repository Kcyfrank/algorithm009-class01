/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 * one 2020 may 22
 * 时间复杂度 On
 * 空间复杂度 O1
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        if(l1.val<=l2.val){
            head.next = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            head.next = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return head.next;
    }
}
// @lc code=end

