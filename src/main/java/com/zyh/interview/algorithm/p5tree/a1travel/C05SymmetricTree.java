package com.zyh.interview.algorithm.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 对称二叉树
 * @author：zhanyh
 * @date: 2023/4/20
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class C05SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }

    private boolean isSymmetricCore(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p != null && q == null) || (p == null && q != null)) return false;
        if(p.val != q.val) return false;
        return isSymmetricCore(p.left, q.left) && isSymmetricCore(p.right, q.right);
    }
}
