package com.zyh.interview.one.p3linklist;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/12
 */
public class ListUtils {
    public static ListNode create(int[] nums) {
        ListNode p = new ListNode();
        ListNode head = p;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.print(p.val);
    }
}
