package com.zyh.interview.one.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description:  二叉搜索树的最近公共祖先
 * @author：zhanyh
 * @date: 2023/8/3
 */
public class O01LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)  return null;

        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
