package com.zyh.interview.algorithm.p2find.a2map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanyh
 * @time 2023/3/16 11:39
 * 2,6,6,11,3,15   9
 */
public class C5TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if(!map.containsKey(target - k)){
                map.put(k, i);
            }else{
                return new int[]{i, map.get(k)};
            }
        }
        return null;
    }

}
