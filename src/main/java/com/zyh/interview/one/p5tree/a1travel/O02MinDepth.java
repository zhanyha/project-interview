package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.Map;
import java.util.Stack;

/**
 * @description: 二叉树的最小深度
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/minimum-depth-of-binary-tree/
public class O02MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return minDepthCore(root);
    }

    private int minDepthCore(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE - 1;
        if (root.left == null && root.right == null)
            return 1;

        return 1 + Math.min(minDepthCore(root.left), minDepthCore(root.right));
    }

    class Command{
        TreeNode node;
        int level;
        String order;

        public Command(TreeNode node, int level, String order) {
            this.node = node;
            this.level = level;
            this.order = order;
        }
    }
    private int minDepthTravel(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<Command> stk = new Stack<>();
        stk.push(new Command(root, 1, "go"));
        while (!stk.isEmpty()){
            Command pop = stk.pop();
            if(pop.order.equals("go")){
                if(pop.node.right != null)
                    stk.push(new Command(pop.node.right, pop.level + 1, "go"));
                if(pop.node.left != null)
                    stk.push(new Command(pop.node.left, pop.level + 1, "go"));
                stk.push(new Command(pop.node, pop.level, "visit"));
            }else{
                res = Math.min(res, pop.level);
            }
        }
        return res;
    }

}
