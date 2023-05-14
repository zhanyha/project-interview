package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 322. 零钱兑换
 * @author：zhanyh
 * @date: 2023/5/10
 */
public class C02CoinChangeBFS {
    class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int coinChange(int[] coins, int amount) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(amount, 0));
        boolean[] visited = new boolean[amount + 1];
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.val == 0)
                return node.step;
            for (int i = 0; i < coins.length; i++) {
                if (node.val - coins[i] >= 0 && !visited[node.val - coins[i]]) {
                    que.add(new Node(node.val - coins[i], node.step + 1));
                    visited[node.val - coins[i]]= true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new C02CoinChangeBFS().coinChange(new int[]{1, 2, 5}, 11));
    }
}
