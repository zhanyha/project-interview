package com.zyh.interview.one.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 236. 二叉树的最近公共祖先
 * @author：zhanyh
 * @date: 2023/8/4
 */
public class O02LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(contains(root.left, p) && contains(root.left, q))
            return lowestCommonAncestor(root.left, p , q);

        if(contains(root.right, p) && contains(root.right, q))
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    private boolean contains(TreeNode root, TreeNode node){
        if(root == null) return false;
        if(root == node) return true;

        if(contains(root.left, node)) return true;

        return contains(root.right, node);
    }
}
