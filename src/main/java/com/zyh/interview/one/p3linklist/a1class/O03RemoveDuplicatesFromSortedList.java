package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// 83  https://leetcode.cn/problems/remove-duplicates-from-sorted-list/

public class O03RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = head, cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }

        }
        return head;
    }
}
