package com.zyh.interview.algorithm.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.BinaryTreeUtils;
import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的所有路径
 * @author：zhanyh
 * @date: 2023/4/20
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class C01BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        List<String> leftNodes = binaryTreePaths(root.left);
        for (String leftNode : leftNodes) {
            res.add(root.val + "->" + leftNode);
        }
        List<String> rightNodes = binaryTreePaths(root.left);
        for (String rightNode : rightNodes) {
            res.add(root.val + "->" + rightNode);
        }
        return res;
    }

    public static void main(String[] args) {
       TreeNode root = BinaryTreeUtils.createTree(new Integer[]{1, 2, 3, null, 5});
       new C01BinaryTreePaths().binaryTreePaths(root);
    }
}
