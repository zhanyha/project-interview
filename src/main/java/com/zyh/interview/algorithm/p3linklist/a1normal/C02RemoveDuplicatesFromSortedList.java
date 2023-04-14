package com.zyh.interview.algorithm.p3linklist.a1normal;

/**
 * @description: 删除排序链表中的重复元素
 * @author：zhanyh
 * @date: 2023/4/11
 * 输入：head = [1,1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class C02RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        if(head == null) return null;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == pre.val){
                pre.next = cur.next;
            }else{
               pre = cur;
            }
            cur = cur.next;

        }
        return head;
    }
}
