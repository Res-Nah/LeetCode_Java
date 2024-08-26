/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp1 = pre.next;
            ListNode temp2 = pre.next.next;
            pre.next = temp2;
            temp1.next = temp2.next;
            temp2.next = temp1;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
// @lc code=end
