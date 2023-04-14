package com.zyh.interview.algorithm.p3linklist.a1normal;

/**
 * @description: 两数相加
 * @author：zhanyh
 * @date: 2023/4/11
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4,7]
 * 输出：[7,0,8,7]
 * 解释：342 + 7465 = 7807.
 * [9,9,9,9,9,9,9]
 * [9,9,9,9]
 */
public class C05AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode p = ret;
        int d = 0;
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + d) % 10;
            d = (l1.val + l2.val + d) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = (l1.val + d) % 10;
            d = (l1.val + d) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = (l2.val + d) % 10;
            d = (l2.val + d) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l2 = l2.next;
        }
        if(d != 0)
            p.next = new ListNode(d);
        return ret.next;
    }
}
