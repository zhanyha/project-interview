package com.zyh.interview.algorithm.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 二叉搜索树的最近公共祖先
 * @author：zhanyh
 * @date: 2023/4/25
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */
public class C01LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val <= root.val && q.val >= root.val) ||
                (p.val >= root.val && q.val <= root.val)) {
            return root;
        }
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        return lowestCommonAncestor(root.right, p, q);

    }
}
