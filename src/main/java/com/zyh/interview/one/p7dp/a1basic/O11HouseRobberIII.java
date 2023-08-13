package com.zyh.interview.one.p7dp.a1basic;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 337. 打家劫舍 III
 * @author：zhanyh
 * @date: 2023/8/13
 */
// https://leetcode.cn/problems/house-robber-iii/
public class O11HouseRobberIII {

    private Map<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return robCore(root);
    }

    public int robCore(TreeNode root) {
        if(root == null) return 0;

        if(memo.get(root) != null)
            return memo.get(root);

        int res1 = root.val  + (root.left != null ? robCore(root.left.left) + robCore(root.left.right) : 0) +
                (root.right != null ? robCore(root.right.left) + robCore(root.right.right) : 0) ;

        int res2 = robCore(root.left) + robCore(root.right);

        memo.put(root, Math.max(res1, res2));
        return Math.max(res1, res2);
    }
}
