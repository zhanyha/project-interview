package com.zyh.interview.one.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 验证二叉搜索树
 * @author：zhanyh
 * @date: 2023/8/4
 */
public class O03ValidateBinarySearchTree {

    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;

        if(pre >= root.val){
            return false;
        }else{
            pre = root.val;
        }

        return isValidBST(root.right);
    }
}
