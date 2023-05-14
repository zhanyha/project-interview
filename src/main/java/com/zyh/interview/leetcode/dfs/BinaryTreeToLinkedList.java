package com.zyh.interview.leetcode.dfs;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 114. 二叉树展开为链表
 * @author：zhanyh
 * @date: 2023/5/14
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class BinaryTreeToLinkedList {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        root.left = null;
        root.right = pre;
        pre = root;
    }

}
