package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 相同的树
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/same-tree/
public class O04SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (q.val != p.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
