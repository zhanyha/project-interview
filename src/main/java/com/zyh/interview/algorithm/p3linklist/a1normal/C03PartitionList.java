package com.zyh.interview.algorithm.p3linklist.a1normal;

/**
 * @description: 分割列表
 * @author：zhanyh
 * @date: 2023/4/11
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class C03PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lt = null;
        ListNode gt = null;
        ListNode cur = head;
        ListNode join = null;
        ListNode retNode = null;
        while (cur != null) {
            if(cur.val < x){
                if(lt == null){
                    lt = cur;
                    retNode = lt;
                }else{
                    lt.next = cur;
                    lt = lt.next;
                }
            }else{
                if(gt == null){
                    gt = cur;
                    join = gt;
                }else{
                    gt.next = cur;
                    gt = gt.next;
                }
            }
            cur = cur.next;
        }
        if(lt == null || gt == null)
            return lt == null ? join : retNode;
        gt.next = null;
        lt.next = join;
        return retNode;
    }
}
