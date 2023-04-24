package com.zyh.interview.algorithm.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 翻转二叉树
 * @author：zhanyh
 * @date: 2023/4/18
 */
public class C03InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTreeCore(root);
        return root;
    }

    private void invertTreeCore(TreeNode root) {
        if(root == null) return;

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTreeCore(root.left);
        invertTreeCore(root.right);
    }
}
