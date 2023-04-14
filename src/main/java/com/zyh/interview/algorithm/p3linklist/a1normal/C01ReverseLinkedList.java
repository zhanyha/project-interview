package com.zyh.interview.algorithm.p3linklist.a1normal;

/**
 * 反转链表
 */
class C01ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while (nxt != null){
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        cur.next = pre;
        return pre;
    }
}