package com.zyh.interview.one.p1array.a1classic;


/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://leetcode.cn/problems/sort-colors/
public class O03SortColor {
    public int[] sortColor(int[] colors) {
        int zero = 0;
        int two = colors.length - 1;
        int cur = 0;
        while (cur <= two) {
            if (colors[cur] == 0) {
                swap(colors, cur, zero);
                zero++;
                cur++;
            } else if (colors[cur] == 2) {
                swap(colors, cur, two);
                two--;
            } else {
                cur++;
            }
        }
        return colors;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] color = new O03SortColor().sortColor(new int[]{0,0,2,1,1,0});
        for (int i = 0; i < color.length; i++) {
            System.out.print(color[i] + " ");
        }
    }
}
