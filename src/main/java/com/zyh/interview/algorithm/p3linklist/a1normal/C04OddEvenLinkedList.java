package com.zyh.interview.algorithm.p3linklist.a1normal;

/**
 * @description: 奇偶链表
 * @author：zhanyh
 * @date: 2023/4/11
 * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 */
public class C04OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = null;
        ListNode odd = null;
        ListNode cur = head;
        ListNode join = null;
        ListNode retNode = null;
        int count = 1;
        while (cur != null) {
            if((count & 1) != 0){
                if(even == null){
                    even = cur;
                    retNode = even;
                }else{
                    even.next = cur;
                    even = even.next;
                }
            }else{
                if(odd == null){
                    odd = cur;
                    join = odd;
                }else{
                    odd.next = cur;
                    odd = odd.next;
                }
            }
            cur = cur.next;
            count++;
        }
        if(even == null || odd == null)
            return even == null ? join : retNode;
        odd.next = null;
        even.next = join;
        return retNode;
    }
}
