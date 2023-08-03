package com.zyh.interview.one.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 437. 路径总和 III
 * @author：zhanyh
 * @date: 2023/8/3
 */
public class O04PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int res = 0;
        res += findTarget(root, targetSum);

        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    public int findTarget(TreeNode root, long targetSum){
        if(root == null) return 0;
        int res = 0;
        if(targetSum == root.val)
            res += 1;
        res += findTarget(root.left, targetSum - root.val);
        res += findTarget(root.right, targetSum - root.val);

        return res;
    }
}
