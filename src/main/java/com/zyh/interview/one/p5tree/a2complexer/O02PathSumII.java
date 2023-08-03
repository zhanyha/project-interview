package com.zyh.interview.one.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 113. 路径总和 II
 * @author：zhanyh
 * @date: 2023/8/3
 */
public class O02PathSumII {

    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        pathSumCore(root, targetSum, new ArrayList<Integer>());

        return res;
    }

    public void pathSumCore(TreeNode root, int targetSum, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null && targetSum == root.val){
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        pathSumCore(root.left, targetSum - root.val, list);

        pathSumCore(root.right, targetSum - root.val, list);

        list.remove(list.size() - 1);

    }
}
