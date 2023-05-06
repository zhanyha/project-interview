package com.zyh.interview.algorithm.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description: 309. 最佳买卖股票时机含冷冻期
 * @author：zhanyh
 * @date: 2023/5/4
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class C12BuyAndSellStockWithCoolDown {
    private int[][] memo;
    private int n;

    public int maxProfit(int[] prices) {
        this.n = prices.length;
        this.memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return maxProfitCore(prices, 0, -1);
    }

    private int maxProfitCore(int[] prices, int index, int status) {
        if (index >= prices.length)
            return 0;
        if(memo[index][status + 1] != -1)
            return memo[index][status + 1];

        int res1 = status * prices[index] + maxProfitCore(prices, status == -1 ? index + 1 : index + 2, -status);
        int res2 = maxProfitCore(prices, index + 1, status);
        int res = Math.max(res1, res2);
        memo[index][status + 1] = res;
        return memo[index][status + 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(new C12BuyAndSellStockWithCoolDown().maxProfit(prices));
    }
}
