package com.zyh.interview.one.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 450. 删除二叉搜索树中的节点
 * @author：zhanyh
 * @date: 2023/8/4
 */
 // https://leetcode.cn/problems/delete-node-in-a-bst/
public class O04DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode node = root.right;
                while (node.left != null)
                    node = node.left;
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
