package com.zyh.interview.company.meitaun;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/19
 */
public class T03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            int[][] dp = new int[n - i][2];
            if (s.charAt(i) == '0') {
                dp[0][1] = 1;
            } else
                dp[0][0] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '0') {
                    dp[j - i][0] = dp[j - i - 1][1];
                    dp[j - i][1] = 1 + dp[j - i - 1][0];
                } else {
                    dp[j - i][0] = 1 + dp[j - i - 1][1];
                    dp[j - i][1] = dp[j - i - 1][0];
                }
                res += Math.min(dp[j - i][0], dp[j - i][1]);
            }
        }
        System.out.println(res);
        sc.close();
    }
}
// 0 0 1
//10001
//1 10, 100 1, 1000 1, 10001 1
//0 00 1, 000 1,  0001 1
//0 00 1, 001 1
//0 01
// 11001
// 1 , 11 1, 110 2, 1100   1010  0101