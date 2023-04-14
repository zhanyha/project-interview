package com.zyh.interview.algorithm.p3linklist.a3complex;

/**
 * @description: 对链表进行插入排序
 * @author：zhanyh
 * @date: 2023/4/11
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 */
public class C09InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        if (head == null) return null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null){
            ListNode q = head;
            while (q.val < cur.val){
                pre = q;
                q = q.next;
            }
            pre.next = cur;
            q.next = cur.next;
            cur.next = q;

            cur = next;
            next = next.next;
        }

        return dummyHead.next;
    }
}
