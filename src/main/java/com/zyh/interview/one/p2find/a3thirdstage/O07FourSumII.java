package com.zyh.interview.one.p2find.a3thirdstage;


import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/4sum-ii/
public class O07FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Long, Integer> oneTwo = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                long sum1 = (long) nums1[i] + (long) nums2[j];
                oneTwo.put(sum1, oneTwo.getOrDefault(sum1, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                long sum2 = (long) nums3[i] + (long) nums4[j];
                if(oneTwo.containsKey( -sum2 )){
                    res += oneTwo.get(-sum2);
                }
            }
        }
        return res;
    }
}
