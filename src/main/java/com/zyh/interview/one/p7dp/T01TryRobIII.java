package com.zyh.interview.one.p7dp;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 打家劫舍
 * @author：zhanyh
 * @date: 2023/7/23
 */
//  https://leetcode.cn/problems/house-robber-iii/
public class T01TryRobIII {

    private Map<TreeNode, Integer> memo;
    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return tryRob(root);
    }

    public int tryRob(TreeNode root) {
        if(root == null) return 0;
        if(memo.get(root) != null)
            return memo.get(root);

        int res1 = root.val;
        if(root.left != null){
            res1 += tryRob(root.left.left);
            res1 += tryRob(root.left.right);
        }
        if(root.right != null){
            res1 += tryRob(root.right.left);
            res1 += tryRob(root.right.right);
        }

        int res2 = tryRob(root.left) + tryRob(root.right);
        int res = Math.max(res1, res2);
        memo.put(root, res);
        return res;
    }
}
