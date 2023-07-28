package com.zyh.interview.one.p4statckandqueue;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 94. 二叉树的中序遍历
 * @author：zhanyh
 * @date: 2023/7/28
 */
// https://leetcode.cn/problems/binary-tree-inorder-traversal/
public class O04BinaryTreeInOrder {
    class Command {
        TreeNode node;
        String order;

        public Command(TreeNode node, String order) {
            this.node = node;
            this.order = order;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Command> stk = new Stack<>();
        stk.push(new Command(root, "go"));
        while (!stk.isEmpty()) {
            Command pop = stk.pop();
            if (pop.order.equals("go")) {
                if (pop.node.right != null)
                    stk.push(new Command(pop.node.right, "go"));

                stk.push(new Command(pop.node, "visit"));

                if (pop.node.left != null)
                    stk.push(new Command(pop.node.left, "go"));
            } else {
                res.add(pop.node.val);
            }
        }
        return res;
    }
}
