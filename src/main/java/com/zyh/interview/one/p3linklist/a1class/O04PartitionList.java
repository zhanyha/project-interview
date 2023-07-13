package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// 86
public class O04PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-2);
        ListNode cur = head, p = smallHead, q = largeHead;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur.next = null;
            cur = next;
        }
        p.next = largeHead.next;
        return smallHead.next;
    }
}
