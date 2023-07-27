package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.*;

/**
 * @description: 二叉树的层序遍历
 * @author：zhanyh
 * @date: 2023/4/14
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class C5BinaryTreeLevelOrderTraversal {
    class Node {
        TreeNode treeNode;
        int level;

        public Node(TreeNode node, int level) {
            this.level = level;
            this.treeNode = node;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(root, 0));
        while (!que.isEmpty()) {
            Node poll = que.poll();
            if (poll.level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(poll.level).add(poll.treeNode.val);
            if (poll.treeNode.left != null)
                que.add(new Node(poll.treeNode.left, poll.level + 1));
            if (poll.treeNode.right != null)
                que.add(new Node(poll.treeNode.right, poll.level + 1));
        }
        return res;
    }
}
