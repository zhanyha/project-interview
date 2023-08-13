package com.zyh.interview.one.p7dp.a1basic;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/13
 */
public class O10HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        memo[0] = nums[0];
        for(int i = 1; i < n - 1; i ++){
            memo[i] = Math.max(memo[i - 1], (i - 2 >= 0 ? memo[i - 2]  : 0) + nums[i]);
        }
        int res1 = memo[n - 2];
        Arrays.fill(memo, 0);

        memo[1] = nums[1];
        for(int i = 2; i < n; i ++){
            memo[i] = Math.max(memo[i - 1], (i - 2 >= 1 ? memo[i - 2] : 0) + nums[i]);
        }

        int res2 = memo[n - 1];

        return Math.max(res1, res2);

    }

}
