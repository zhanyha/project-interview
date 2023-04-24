package com.zyh.interview.algorithm.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 路径总和
 * @author：zhanyh
 * @date: 2023/4/20
 */
public class C08PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
