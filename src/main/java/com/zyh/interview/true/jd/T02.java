package com.zyh.interview;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/12
 */
public class T02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int[][] memo = new int[n][10];
        memo[n - 1][nums[n - 1] % 10] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int tmp = nums[i];
            for (int j = 0; j <= 9; j++) {
                if(memo[i +  1][j] != 0){
                    int add = (tmp + j) % 10;
                    int mul = ((tmp % 10) * (j % 10)) % 10;
                    memo[i][add] = (memo[i+1][j] + memo[i][add]) % ((int) (Math.pow(10, 9) + 7));
                    memo[i][mul] = (memo[i+1][j] + memo[i][mul]) % ((int) (Math.pow(10, 9) + 7));
                }
            }
        }
        for (int i = 0; i < memo[0].length; i++) {
            if(i != memo[0].length - 1)
                System.out.print(memo[0][i] + " ");
            else
                System.out.print(memo[0][i]);
        }
        sc.close();
    }
}
