package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 左叶子之和
 * @author：zhanyh
 * @date: 2023/8/1
 */
public class O09SumOfLeftLeaves {

    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesCore(root, false);

        return res;
    }

    private void sumOfLeftLeavesCore(TreeNode root, boolean isLeft){
        if(root == null) return;

        if(isLeft && root.left == null && root.right == null){
            res += root.val;
        }

        sumOfLeftLeavesCore(root.left, true);
        sumOfLeftLeavesCore(root.right, false);
    }
}
