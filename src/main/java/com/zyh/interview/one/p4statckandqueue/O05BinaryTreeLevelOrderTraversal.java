package com.zyh.interview.one.p4statckandqueue;


import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.*;

/**
 * @description: 102. 二叉树的层序遍历
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class O05BinaryTreeLevelOrderTraversal {
    class Node {
        int level;
        TreeNode treeNode;

        public Node(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0, root));
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.treeNode.left != null)
                que.add(new Node(node.level + 1, node.treeNode.left));
            if (node.treeNode.right != null)
                que.add(new Node(node.level + 1, node.treeNode.right));
            if (res.size() == node.level) {
                List<Integer> list = new ArrayList<>();
                res.add(list);
            }
            res.get(node.level).add(node.treeNode.val);
        }
        return res;
    }


}
