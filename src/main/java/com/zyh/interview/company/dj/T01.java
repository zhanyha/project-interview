package com.zyh.interview.company.dj;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class T01 {

    public int circle_fly(int[] charge, int[] cost) {
        int n = charge.length;
        int c = 0;
        for (int i = 0; i < n; i++) {

            int leftCount = n;
            boolean f = false;
            int j = i;
            while (leftCount > 0) {
                c += charge[i];
                if (cost[j] > c) {
                    break;
                }
                c -= cost[j];
                leftCount--;
                if (leftCount == 0) {
                    f = true;
                }
                j = (j + 1) % n;
            }
            c = 0;
            if (f)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] charge = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(new T01().circle_fly(charge, cost));
    }
}
