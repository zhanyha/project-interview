package com.zyh.interview.algorithm.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 平衡二叉树
 * @author：zhanyh
 * @date: 2023/4/20
 */
public class C07BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(isBalancedCore(root) == -1) return false;
        return true;
    }

    private int isBalancedCore(TreeNode root) {
        if (root == null)
            return 0;
        int left = isBalancedCore(root.left);
        if (left == -1) return -1;
        int right = isBalancedCore(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;

    }
}
