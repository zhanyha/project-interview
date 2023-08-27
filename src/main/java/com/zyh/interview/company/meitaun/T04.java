package com.zyh.interview.company.meitaun;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/19
 */
public class T04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int len = 501;
        int[][] memo = new int[n + 1][len];
        memo[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < len; j++) {
                for (int k = 1; k <= j; k++) {
                    if (k != nums[i - 1]) {
                        memo[i][j] = (memo[i][j] + memo[i - 1][j - k]) % (int) (Math.pow(10, 9) + 7);
                    }
                }
            }
        }
        System.out.println(memo[n][sum]);
        sc.close();
    }
}
