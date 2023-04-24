package com.zyh.interview.algorithm.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 完全二叉树的节点个数
 * @author：zhanyh
 * @date: 2023/4/20
 */
public class C06CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftCount =  countNodes(root.left);
        int rightCount =  countNodes(root.right);
        return leftCount + rightCount + 1;
    }
}
