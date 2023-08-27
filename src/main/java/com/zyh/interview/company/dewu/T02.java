package com.zyh.interview.company.dewu;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/23
 */
public class T02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i] = (i == nums[0] ? 1 : m + 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if(j >= nums[i]){
                    dp[j] = Math.min(dp[j] , 1 + dp[ j - nums[i]]);
                }
            }
        }
//        Class<BigDecimal> bigDecimalClass = Class.forName("");
//        Method[] methods = bigDecimalClass.getMethod("he");

        System.out.println(dp[m] == m+1 ? "No solution" : dp[m]);
        sc.close();
    }
}
