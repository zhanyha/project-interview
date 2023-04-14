package com.zyh.interview.algorithm.p3linklist.a5doubblepointer;

/**
 * @description: 旋转链表
 * @author：zhanyh 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @date: 2023/4/13
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */
public class C11RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0) return head;
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        p = head;
        ListNode newHead = head;
        ListNode pre = dummyNode;
        while (k - 1 > 0) {
            p = p.next;
            k--;
        }
        while (p.next != null) {
            p = p.next;
            pre = newHead;
            newHead = newHead.next;
        }
        p.next = head;
        pre.next = null;
        return newHead;
    }
}
