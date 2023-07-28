package com.zyh.interview.one.p4statckandqueue;


import com.zyh.interview.algorithm.p4stackandqueue.C6BinaryTreeZigzagTraversal;
import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.*;

/**
 * @description: 103 二叉树的锯齿形层序遍历
 * @author：zhanyh
 * @date: 2023/7/28
 */

// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class O06BinaryTreeZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int level = 0;
        while (!que.isEmpty()){
            Queue<TreeNode> newQue = new ArrayDeque<>();
            LinkedList<Integer> list = new LinkedList<>();
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = que.poll();
                if(level % 2 == 0){
                    list.addLast(poll.val);
                }else{
                    list.addFirst(poll.val);
                }
                if (poll.left != null) {
                    newQue.add(poll.left);
                }
                if (poll.right != null) {
                    newQue.add(poll.right);
                }
            }
            level++;
            que = newQue;
            res.add(list);
        }
        return res;
    }
}
