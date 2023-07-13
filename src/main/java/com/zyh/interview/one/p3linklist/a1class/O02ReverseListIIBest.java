package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;
import com.zyh.interview.one.p3linklist.ListUtils;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// https://leetcode.cn/problems/reverse-linked-list-ii/
public class O02ReverseListIIBest {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead, second = first.next;
        for (int i = 0; i < left - 1; i++) {
            first = first.next;
            second = first.next;
        }
        ListNode third = second, fourth = third.next;
        for (int i = 0; i < right - left; i++) {
            third = third.next;
            fourth = third.next;
        }

        first.next = null;
        third.next = null;

        ListNode subHead = reverseList(second);

        first.next = subHead;
        second.next = fourth;

        return dummyHead.next;
    }

    private ListNode reverseList(ListNode subHead) {
        ListNode pre = null, cur = subHead;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.create(new int[]{1, 2, 3, 4, 5});
        ListNode p = new O02ReverseListIIBest().reverseBetween(head, 1, 3);
        ListUtils.print(p);
    }
}
