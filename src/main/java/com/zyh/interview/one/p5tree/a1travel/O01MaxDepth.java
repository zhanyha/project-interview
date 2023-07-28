package com.zyh.interview.one.p5tree.a1travel;

import com.zyh.interview.algorithm.p5tree.TreeNode;

import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/28
 */
public class O01MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    class Command {
        TreeNode node;
        int level;
        String order;

        public Command(TreeNode node, int level, String order) {
            this.node = node;
            this.level = level;
            this.order = order;
        }
    }

    public int maxDepthTravel(TreeNode root) {
        if (root == null)
            return 0;
        Stack<Command> stk = new Stack<>();
        stk.push(new Command(root, 1, "go"));
        int res = 0;
        while (!stk.isEmpty()) {
            Command pop = stk.pop();
            if (pop.order.equals("go")) {
                if (pop.node.right != null)
                    stk.push(new Command(pop.node.right, pop.level + 1, "go"));

                if (pop.node.left != null)
                    stk.push(new Command(pop.node.left, pop.level + 1, "go"));

                stk.push(new Command(pop.node, pop.level, "visit"));
            } else {
                res = Math.max(res, pop.level);
            }
        }
        return res;
    }
}
