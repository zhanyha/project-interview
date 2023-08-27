package com.zyh.interview.company.meitaun;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/19
 */
public class T02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        int[] arrs = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arrs[i] = sc.nextInt();
            sum += arrs[i];
        }
        long res = 0;
        long t;
        for (int i = 1; i < n; i++) {
            t = sum;
            t = t - arrs[i-1] - arrs[i] + (long) arrs[i - 1] * arrs[i];
            res = Math.max(t, res);
        }
        System.out.println(res);
        sc.close();
    }
}
