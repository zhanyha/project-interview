package com.zyh.interview.algorithm.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 相同的树
 * @author：zhanyh
 * @date: 2023/4/20
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class C04SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null){
            return q == null;
        }
        if(q == null){
            return false;
        }
        if(p.val != q.val)
            return false;
        if(!isSameTree(p.left, q.left)) return false;
        if(!isSameTree(p.right, q.right)) return false;
        return true;
    }
}
