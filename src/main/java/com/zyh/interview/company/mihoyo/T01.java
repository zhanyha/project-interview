package com.zyh.interview.company.mihoyo;


import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class T01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int res = 0;
        res += step(n,m,x1,y1,x2,y2);
        res += step(n,m,x2,y2,x3,y3);
        System.out.println(res);
        sc.close();
    }

    private static int step(int n, int m, int x1, int y1, int x2, int y2) {
        int maxX = Math.max(x1,x2);
        int minX = Math.min(x1,x2);

        int x = Math.min(maxX - minX, minX - maxX + n);

        int maxY = Math.max(y1,y2);
        int minY = Math.min(y1,y2);

        int y = Math.min(maxY - minY, minY - maxY + m);

        return x + y;
    }
}
