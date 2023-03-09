/**
 * @author zhanyuhao
 * @time 2023/2/7 14:16
 */
package com.zyh.interview.algorithm.p1arrays.a1经典;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">L75</a>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class C02SortColor {

    public void sortColors(int[] nums) {
        int zero = -1; // [0, zero] 都是零
        int two = nums.length;// [two, nums.length] 都是2

        int i = 0;
        while (i < two) {
            if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            }else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        new C02SortColor().sortColors(arr);
    }
}
