package com.zyh.interview.algorithm.p4stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历
 * @author：zhanyh
 * @date: 2023/4/14
 */
public class C4BinaryTreeInOrder {
    class Command {
        String order;
        TreeNode node;

        public Command(String order, TreeNode val) {
            this.order = order;
            this.node = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Command> stk = new Stack<>();
        stk.push(new Command("go", root));
        while (!stk.isEmpty()) {
            Command cmd = stk.pop();
            if (cmd.order.equals("go")) {
                if (cmd.node.right != null)
                    stk.push(new Command("go", cmd.node.right));
                stk.push(new Command("print", cmd.node));
                if (cmd.node.left != null)
                    stk.push(new Command("go", cmd.node.left));
            } else {
                res.add(cmd.node.val);
            }
        }
        return res;
    }
}
