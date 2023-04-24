package com.zyh.interview.algorithm.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 和C08PathSum.java 不同的是， 这里还需要求路径
 * @author：zhanyh
 * @date: 2023/4/21
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。叶子节点 是指没有子节点的节点。
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class C03TreePathsSumII {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;
        List<Integer> list = new ArrayList<>();
        pathSumCore(root, targetSum, list);
        return res;
    }

    private void pathSumCore(TreeNode root, int targetSum, List<Integer> list) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        pathSumCore(root.left, targetSum - root.val, list);
        pathSumCore(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }
}
