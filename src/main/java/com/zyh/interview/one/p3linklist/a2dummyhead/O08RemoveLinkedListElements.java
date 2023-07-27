package com.zyh.interview.one.p3linklist.a2dummyhead;

import com.zyh.interview.one.p3linklist.ListNode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// 203 https://leetcode.cn/problems/remove-linked-list-elements/submissions/
public class O08RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = pre.next;
        while(cur != null){
            ListNode next = cur.next;
            if(cur.val == val){
                pre.next = next;
            }else{
                pre = cur;
            }
            cur = next;
        }

        return dummyHead.next;

    }
}
