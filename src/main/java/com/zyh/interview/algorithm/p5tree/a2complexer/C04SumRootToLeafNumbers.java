package com.zyh.interview.algorithm.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.BinaryTreeUtils;
import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 求根节点到叶节点数字之和
 * @author：zhanyh
 * @date: 2023/4/24
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 输入：root = [1,2,3]
 * 输出：25
 */
public class C04SumRootToLeafNumbers {
    private List<String> res = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        sumNumbersCore(root, "");

        int sum = 0;
        for (String str : res) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }


    private void sumNumbersCore(TreeNode root, String s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            s += root.val;
            res.add(s);
            return;
        }
        sumNumbersCore(root.left, s + root.val);
        sumNumbersCore(root.right, s + root.val);
    }

    public static void main(String[] args) {
        TreeNode tree = BinaryTreeUtils.createTree(new Integer[]{1, 2, 3});
        System.out.println(new C04SumRootToLeafNumbers().sumNumbers(tree));
    }
}
