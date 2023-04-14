package com.zyh.interview.algorithm.p3linklist.a3complex;

/**
 * @description: 两两交换链表中的节点
 * @author：zhanyh
 * @date: 2023/4/11
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class C08SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode node1 = head;
        if (head == null) return null;
        ListNode node2 = node1.next;
        while (node2 != null) {
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            pre = node1;
            node1 = pre.next;
            if(node1 != null)
                node2 = node1.next;
            else
                node2 = null;
        }
        return dummyHead.next;
    }
}
