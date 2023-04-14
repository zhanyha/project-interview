package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的锯齿形层序遍历
 * @author：zhanyh
 * @date: 2023/4/14
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class C6BinaryTreeZigzagTraversal {
    class Node{
        TreeNode treeNode;
        int level;

        public Node(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(root, 0));
        while (!que.isEmpty()){
            Node poll = que.poll();
            if(poll.level == res.size())
                res.add(new ArrayList<>());
            res.get(poll.level).add(poll.treeNode.val);
            if((poll.level & 1) == 0){
                if(poll.treeNode.right != null)
                    que.add(new Node(poll.treeNode.right, poll.level + 1));
                if(poll.treeNode.left != null)
                    que.add(new Node(poll.treeNode.left, poll.level + 1));
            }else{
                if(poll.treeNode.left != null)
                    que.add(new Node(poll.treeNode.left, poll.level + 1));
                if(poll.treeNode.right != null)
                    que.add(new Node(poll.treeNode.right, poll.level + 1));
            }
        }
        return res;
    }
}
