package com.zyh.interview.algorithm.p7dp.a2knapsack.leetcode;

/**
 * @description: 474. 一和零
 * @author：zhanyh
 * @date: 2023/5/10
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 */
public class C04OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] memo = new int[strs.length][(m+1) * (n+1)];
        for (int i = 0; i < (m+1) * (n+1); i++) {
            if (getZeroCount(strs[0]) <= i / (n + 1) && getOneCount(strs[0]) <= i % (n+1))
                memo[0][i] = 1;
        }
        for (int i = 1; i < strs.length; i++) {
            for (int j = 1; j < (m+1) * (n+1); j++) {

                int zeroCount = getZeroCount(strs[i]);
                int oneCount = getOneCount(strs[i]);
                int ZeroCap =  j / (n+1);
                int OneCap =  j % (n+1);
                memo[i][j] = memo[i-1][j];
                if(ZeroCap - zeroCount >= 0 && OneCap - oneCount >= 0)
                    memo[i][j] = Math.max(memo[i-1][j], 1+memo[i-1][(ZeroCap - zeroCount) * (n+1) + (OneCap - oneCount)]);
            }
        }
        return memo[strs.length - 1][(m+1) * (n+1) - 1];
    }

    private int getZeroCount(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                res++;
        }
        return res;
    }

    private int getOneCount(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new C04OnesAndZeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
