/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    private int size;

    private ListNode dummy;

    public MyLinkedList() {
        this.size = 0;
        this.dummy = new ListNode(-1, null);
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        ListNode pre = dummy;
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        return pre.next.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val, dummy.next);
        dummy.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val, null);
        int index = size;
        ListNode pre = dummy;
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        pre.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode pre = dummy;
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        ListNode node = new ListNode(val, pre.next);
        pre.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        ListNode pre = dummy;
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        pre.next = pre.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

