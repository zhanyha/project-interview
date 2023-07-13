package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// 445 https://leetcode.cn/problems/add-two-numbers-ii/
public class O07AddTwoNumberII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, cur = null;

        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        while (p1 != null) {
            stk1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            stk2.push(p2.val);
            p2 = p2.next;
        }
        int c = 0;
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            Integer pop1 = stk1.pop();
            Integer pop2 = stk2.pop();
            ListNode node = new ListNode((pop1 + pop2 + c) % 10);
            dummyHead.next = node;
            node.next = cur;
            cur = node;
            c = (pop1 + pop2 + c) / 10;
        }

        while (!stk1.isEmpty()) {
            Integer pop1 = stk1.pop();
            ListNode node = new ListNode((pop1 + c) % 10);
            dummyHead.next = node;
            node.next = cur;
            cur = node;
            c = (pop1 + c) / 10;
        }

        while (!stk2.isEmpty()) {
            Integer pop2 = stk2.pop();
            ListNode node = new ListNode((pop2 + c) % 10);
            dummyHead.next = node;
            node.next = cur;
            cur = node;
            c = (pop2 + c) / 10;
        }
        if (c != 0) {
            ListNode node = new ListNode( c );
            dummyHead.next = node;
            node.next = cur;
            cur = node;
        }

        return dummyHead.next;
    }
}
