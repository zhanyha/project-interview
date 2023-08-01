package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 110. 平衡二叉树
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/balanced-binary-tree/
public class O07BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) > 1)
            return false;
        if(!isBalanced(root.left)) return false;
        if(!isBalanced(root.right)) return false;
        return true;
    }

    private int getTreeHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }
}
