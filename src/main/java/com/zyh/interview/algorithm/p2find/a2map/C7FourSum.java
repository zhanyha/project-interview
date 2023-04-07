package com.zyh.interview.algorithm.p2find.a2map;

import java.util.*;

/**
 * @author zhanyh
 * @time 2023/3/23 9:08
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * 若两个四元组元素一一对应，则认为两个四元组重复）
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * <b>提示：</b>
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */
public class C7FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put((long) (nums[i]), i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long left = (long) (target) - (long) (nums[i]) - (long) (nums[j]) - (long) (nums[k]);
                    String idStr = target + " " + nums[i] + " " + nums[j] + " " + nums[k];
                    if (map.containsKey(left) && map.get(left) > k &&
                            !hashSet.contains(idStr)) {
                        hashSet.add(idStr);
                        res.add(Arrays.asList((int) left, nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }

    public void test() {
        int[] nums = new int[]{-1, 2, -1, -4, -1, -1, -1, -1, -1};
        int target = -4;
        List<List<Integer>> resp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> ans = new ArrayList<>();
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[k]);
                            ans.add(nums[l]);
                            Collections.sort(ans);
                            if (!resp.contains(ans)) {
                                resp.add(ans);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(resp);
    }

    public static void main(String[] args) {
//        System.out.println(new C7FourSum().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
        new C7FourSum().test();
    }
}
