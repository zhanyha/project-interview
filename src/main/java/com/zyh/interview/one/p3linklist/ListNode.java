package com.zyh.interview.one.p3linklist;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
