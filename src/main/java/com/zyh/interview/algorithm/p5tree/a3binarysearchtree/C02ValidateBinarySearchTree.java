package com.zyh.interview.algorithm.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.HashMap;

/**
 * @description: 验证二叉搜索树
 * @author：zhanyh
 * @date: 2023/4/25
 * 你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class C02ValidateBinarySearchTree {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean b1 = isValidBST(root.left);
        if(!b1) return false;
        if (pre < root.val) {
            pre = root.val;
        } else {
            return false;
        }
        boolean b2 = isValidBST(root.right);
        if(!b2) return false;
        return b1 && b2;
    }
}
