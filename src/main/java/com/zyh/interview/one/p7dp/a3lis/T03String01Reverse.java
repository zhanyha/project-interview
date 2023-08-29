package com.zyh.interview.one.p7dp.a3lis;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * 小美定义一个 01 串的权值为：每次操作选择一位取反，使得相邻字符都不相等的最小操作次数。
 * 例如，"10001"的权值是 1，因为只需要修改一次：对第三个字符取反即可。
 * 现在小美拿到了一个 01 串，她希望你求出所有非空连续子串的权值之和，你能帮帮她吗？
 * @author：zhanyh
 * @date: 2023/8/29
 */
// https://www.nowcoder.com/questionTerminal/33332352abb642cf9b77eac1f7eeb720
public class T03String01Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int[][] dp = new int[n][2];

        int res = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i; j < n; j ++) {
                if (s.charAt(j) == '0') {
                    dp[j][0] = j - 1 >= 0 ? dp[j - 1][1] : 0;
                    dp[j][1] = j - 1 >= 0 ? dp[j - 1][0] + 1 : 1;
                } else {
                    dp[j][0] = j - 1 >= 0 ? dp[j - 1][1] + 1 : 1;
                    dp[j][1] = j - 1 >= 0 ? dp[j - 1][0] : 0;
                }
                res += Math.min(dp[j][0], dp[j][1]);
            }
            for(int k = 0; k < n; k ++)
                Arrays.fill(dp[i], 0);
        }
        System.out.println(res);
        sc.close();
    }

}
