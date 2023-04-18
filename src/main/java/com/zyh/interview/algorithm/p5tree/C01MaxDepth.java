package com.zyh.interview.algorithm.p5tree;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/4/16
 */
public class C01MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
