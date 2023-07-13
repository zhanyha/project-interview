package com.zyh.interview.one.p3linklist.a1class;

import com.zyh.interview.one.p3linklist.ListNode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/11
 */
// 328
public class O05OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-2);

        ListNode cur = head, p = odd, q = even;
        int index = 0;
        while(cur != null){
            ListNode next = cur.next;
            if(++index % 2 == 0){
                p.next = cur;
                p = p.next;
            }else{
                q.next = cur;
                q = q.next;
            }
            cur.next = null;
            cur = next;
        }
        q.next = odd.next;
        return even.next;
    }
}
