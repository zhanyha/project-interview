package com.zyh.interview.one.p5tree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/12
 */
// 144 https://leetcode.cn/problems/binary-tree-preorder-traversal/
public class T01PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Command command = new Command("go", root);
        Stack<Command> stk = new Stack();
        stk.push(command);
        while (!stk.isEmpty()) {
            Command c = stk.pop();
            if (c.type.equals("print")) {
                res.add(c.node.val);
            } else if (c.type.equals("go")) {

                if (c.node.right != null) {
                    stk.push(new Command("go", c.node.right));
                }
                if (c.node.left != null) {
                    stk.push(new Command("go", c.node.left));
                }

                stk.push(new Command("print", c.node));

            }
        }


        return res;
    }
}

class Command {
    String type;
    TreeNode node;

    public Command(String type, TreeNode node) {
        this.type = type;
        this.node = node;
    }
}