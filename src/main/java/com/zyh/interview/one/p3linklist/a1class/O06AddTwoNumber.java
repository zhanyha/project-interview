package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;
import com.zyh.interview.one.p3linklist.ListUtils;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// 2  https://leetcode.cn/problems/add-two-numbers/
public class O06AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (p1 != null && p2 != null) {
            int n = (p1.val + p2.val + c) % 10;
            c = (p1.val + p2.val + c) / 10;
            cur.next = new ListNode(n);
            cur = cur.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int n = (p1.val + c) % 10;
            c = (p1.val + p1.val + c) / 10;
            cur.next = new ListNode(n);
            cur = cur.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int n = (p2.val + c) % 10;
            c = (p2.val + c) / 10;
            cur.next = new ListNode(n);
            cur = cur.next;
            p2 = p2.next;
        }
        if(c != 0){
            cur.next = new ListNode(c);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.create(new int[]{8, 9, 9, 9, 9});
        ListNode head2 = ListUtils.create(new int[]{8, 9, 9});
        ListNode res = new O06AddTwoNumber().addTwoNumbers(head1, head2);
        ListUtils.print(res);
    }
}
