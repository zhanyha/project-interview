package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 完全二叉树的节点个数
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/count-complete-tree-nodes/
public class O06CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
