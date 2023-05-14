package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 322. 零钱兑换
 * @author：zhanyh
 * @date: 2023/5/10
 */
public class C02CoinChangeDP {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0)
            return 0;
        int[] memo = new int[amount + 1];
        for (int i = 1; i < memo.length; i++) {
            memo[i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < memo.length; j++) {
                if (j - coins[i] >= 0) {
                    memo[j] = Math.min(memo[j], 1 + memo[j - coins[i]]);
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE - 1 ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new C02CoinChangeDP().coinChange(new int[]{2, 4, 6}, 16));
    }
}
