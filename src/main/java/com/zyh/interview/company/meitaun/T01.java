package com.zyh.interview.company.meitaun;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/19
 */
public class T01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            res[i] = b % a == 0 ? a : b % a;
        }
        for (int e : res)
            System.out.println(e);
        sc.close();
    }
}
