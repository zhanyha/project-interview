package com.zyh.interview.algorithm.p3linklist.a5doubblepointer;

/**
 * @description: 环形链表
 * @author：zhanyh
 * @date: 2023/4/13
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class C12LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else
                break;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
