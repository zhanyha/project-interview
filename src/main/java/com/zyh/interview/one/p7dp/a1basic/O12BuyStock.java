package com.zyh.interview.one.p7dp.a1basic;

/**
 * @description: 309. 最佳买卖股票时机含冷冻期
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O12BuyStock {
    private int[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][3];
        return maxProfitCore(prices, 0, -1);
    }

    private int maxProfitCore(int[] prices, int index, int status){

        if(index >= prices.length) return 0;
        if(memo[index][status + 1] != 0)
            return memo[index][status + 1];

        int res1 = status * prices[index] + (status == 1 ? maxProfitCore(prices, index + 2,  -status) : maxProfitCore(prices, index + 1,  -status));

        int res2 = maxProfitCore(prices, index + 1, status);

        memo[index][status + 1] = Math.max(res1, res2);
        return Math.max(res1, res2);
    }
}
