package com.zyh.interview;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/12
 */
public class T01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int res = str.length() + 1;
        for (int i = 0; i < n / 2; i++) {
            int k = i;
            for (int j = 0; j < n / 2; j++) {
                if (str.charAt((i + j) % n) != str.charAt((n - j - 1 + i) % n))
                    k++;
            }
            res = Math.min(res, k);
        }
        System.out.println(res);
        sc.close();
    }

}
