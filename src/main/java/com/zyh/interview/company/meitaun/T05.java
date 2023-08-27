package com.zyh.interview.company.meitaun;

import java.util.Scanner;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/19
 */
public class T05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        double avg = (double) sum / n;
        int res = 0;
        if (avg == sum / n) {
            for (int i = 0; i < n; i++) {
                if (nums[i] > avg)
                    res = (int) (res + nums[i] - avg);
            }
            System.out.println(res);
        } else {
            int discard = 0;
            for (int i = 1; i < n; i++) {
                if (Math.abs(nums[i] - avg) > Math.abs(avg - nums[discard])) {
                    discard = i;
                }
            }
            avg = (sum - nums[discard]) / (n - 1);
            for (int i = 0; i < n; i++) {
                if (i != discard && nums[i] > avg) {
                    res = (int) (res + nums[i] - avg);
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}

//6
//2 4 4 1 8 5
