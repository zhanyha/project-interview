package com.zyh.interview.algorithm.p3linklist.a2dummyhead;

/**
 * @description: 合并两个有序链表
 * @author：zhanyh
 * @date: 2023/4/11
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class C07MergeLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode p = res;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            p = p.next;

        }
        while(list1 != null){
            p.next = new ListNode(list1.val);
            list1 = list1.next;
            p = p.next;
        }
        while(list2 != null){
            p.next = new ListNode(list2.val);
            list2 = list2.next;
            p = p.next;
        }
        return res.next;
    }
}
