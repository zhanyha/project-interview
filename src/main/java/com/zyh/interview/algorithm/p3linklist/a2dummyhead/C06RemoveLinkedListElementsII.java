package com.zyh.interview.algorithm.p3linklist.a2dummyhead;

/**
 * @description: 移除链表重复出现的元素
 * @author：zhanyh
 * @date: 2023/4/11
 * 给定一个已排序的链表的头 head ，
 * 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 输入：head = [1,1,1,2,2,3,4,4,5]
 * 输出：[3,5]
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * 1 2 3 3 4 4 5
 */
public class C06RemoveLinkedListElementsII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(101);
        dummyHead.next = head;
        ListNode line = dummyHead;
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (cur.val != pre.val && cur.val != next.val) {
                line.next = cur;
                line = cur;
            }
            pre = cur;
            cur = next;
            next = next.next;
        }
        if (cur.val != pre.val) {
            line.next = cur;
            line = cur;
        }
        line.next = null;
        return dummyHead.next;
    }
}
