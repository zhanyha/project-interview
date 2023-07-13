package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;
import com.zyh.interview.one.p3linklist.ListUtils;
import lombok.var;

import java.util.List;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// https://leetcode.cn/problems/reverse-linked-list-ii/
public class O02ReverseListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pos = dummyHead;
        for (int i = 1; i <= left - 1; i++) {
            pos = pos.next;
        }

        ListNode cur = pos.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            ListNode last = pos.next;
            pos.next = next;
            cur.next = next.next;
            next.next = last;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.create(new int[]{1, 2, 3, 4, 5});
        ListNode p = new O02ReverseListII().reverseBetween(head, 1, 4);
        ListUtils.print(p);
    }
}
