package com.zyh.interview.algorithm.p8bit;

/**
 * @description: 137. 只出现一次的数字 II
 * @author：zhanyh
 * @date: 2023/5/22
 * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C01SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        for (int i = 0; i < nums.length; i++) {
            String s = Integer.toString(nums[i], 2);
            for (int j = 0; j < s.length(); j++) {
                res[s.length() - 1 - j] = (res[s.length() - 1 - j] + s.charAt(j) - '0') % 3;
            }
        }
        StringBuilder sbr = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            sbr.append(res[i]);
        }
        return Integer.valueOf(sbr.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(new C01SingleNumberII().singleNumber(
                new int[]{1, 1, 1, 3, 3, 3, 4, 2, 2, 2,5,5,5}
        ));
        System.out.println(-5 % 3);
    }
}
