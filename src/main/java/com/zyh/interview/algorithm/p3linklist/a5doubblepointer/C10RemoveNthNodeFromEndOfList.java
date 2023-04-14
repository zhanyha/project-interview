package com.zyh.interview.algorithm.p3linklist.a5doubblepointer;

/**
 * @description: 删除链表的倒数第 N 个结点
 * @author：zhanyh
 * @date: 2023/4/13
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class C10RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead;
        while (n > 0) {
            cur = cur.next;
            n--;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        ListNode p = dummyHead;
        while (p.next != pre) {
            p = p.next;
        }
        p.next = pre.next;
        return dummyHead.next;
    }
}
