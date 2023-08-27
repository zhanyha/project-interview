package com.zyh.interview.company.dewu;

import java.util.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/23
 */
public class T01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 0;
        int[] mark = new int[n];
        int left = 0, right = 0;
        int index = n - 1;
        if(n % 2 == 0){
            left = n / 2 - 1;
            right = n / 2;
        }else{
            int mid = n / 2;
            mark[mid] = nums[index];
            index--;
            left = mid + 1;
            right = mid + 1;
        }
        while (left >= 0 && right < n && index >= 0){
            mark[left] = nums[index];
            left--;
            index--;
            mark[right] = nums[index];
            right++;
            index--;
        }
        for (int i = 0; i < n; i++) {
            int x = Math.abs(mark[i] - mark[(i + 1) % n]);
            int y = Math.abs(mark[i] - mark[(i - 1 + n) % n]);
            res = Math.max(res,  x);
            res = Math.max(res,  y);
        }
        System.out.println(res);
        sc.close();
    }
}
