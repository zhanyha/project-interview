package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 对称二叉树
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/symmetric-tree/
public class O05SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetricCore(root.left, root.right);
    }

    private boolean isSymmetricCore(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSymmetricCore(p.left, q.right) && isSymmetricCore(p.right, q.left);
    }
}
