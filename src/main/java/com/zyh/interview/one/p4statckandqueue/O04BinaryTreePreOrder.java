package com.zyh.interview.one.p4statckandqueue;


import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历
 * @author：zhanyh
 * @date: 2023/4/14
 */
public class O04BinaryTreePreOrder {
    class Command {
        String order;
        TreeNode node;

        public Command(String order, TreeNode val) {
            this.order = order;
            this.node = val;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Command> stk = new Stack<>();
        stk.push(new Command("go", root));
        while (!stk.isEmpty()) {
            Command cmd = stk.pop();
            if (cmd.order.equals("go")) {
                if (cmd.node.right != null)
                    stk.push(new Command("go", cmd.node.right));
                if (cmd.node.left != null)
                    stk.push(new Command("go", cmd.node.left));
                stk.push(new Command("visit", cmd.node));
            } else {
                res.add(cmd.node.val);
            }
        }
        return res;
    }
}
