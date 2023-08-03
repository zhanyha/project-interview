package com.zyh.interview.one.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:  二叉树的所有路径
 * @author：zhanyh
 * @date: 2023/8/3
 */
public class O01BinaryTreePaths {

    private List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {

        res = new ArrayList<>();

        binaryTreePathsCore(root, "");

        return res;
    }

    public void binaryTreePathsCore(TreeNode root, String path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            res.add(path + root.val);
        }
        binaryTreePathsCore(root.left, path + root.val + "->");
        binaryTreePathsCore(root.right, path + root.val + "->");
    }

}
