package com.zyh.interview.one.p2find.a2secondstage;

import java.util.Map;
import java.util.TreeSet;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/7/9
 */
// https://leetcode.cn/problems/3sum-closest/
public class O06ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        TreeSet<Integer> set = new TreeSet<>();
        int left;
        int minGap = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                left = target - nums[i] - nums[j];
                Integer ceiling = set.ceiling(left);
                if (ceiling != null) {
                    int gap = Math.abs(target - (nums[i] + nums[j] + ceiling));
                    if (gap < minGap) {
                        minGap = gap;
                        res = nums[i] + nums[j] + ceiling;
                    }
                }
                Integer floor = set.floor(left);
                if (floor != null) {
                    int gap = Math.abs(target - (nums[i] + nums[j] + floor));
                    if (gap < minGap) {
                        minGap = gap;
                        res = nums[i] + nums[j] + floor;
                    }
                }
            }
            set.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new O06ThreeSumClosest().threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}
