package com.zyh.interview.one.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 求根节点到叶节点数字之和
 * @author：zhanyh
 * @date: 2023/8/3
 */
public class O03SumRootToLeafNumbers {
    private int res = 0;
    public int sumNumbers(TreeNode root) {

        sumNumbersCore(root, "");

        return res;
    }

    public void sumNumbersCore(TreeNode root, String path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            path += root.val;
            res += Integer.parseInt(path);
            return;
        }

        sumNumbersCore(root.left, path + root.val);
        sumNumbersCore(root.right, path + root.val);
    }
}
