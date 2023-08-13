package com.zyh.interview.one.p10contest.code357;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 2811. 判断是否能拆分数组
 * @author：zhanyh
 * @date: 2023/8/10
 */
public class T02SplitArray {

    public boolean canSplitArray(List<Integer> nums, int m) {
        List<String> list = new ArrayList<>();
        StringBuilder numStr = new StringBuilder();
        for (int e : nums)
            numStr.append(e);
        return canSplitArrayCore(numStr.toString(), nums, m, list);
    }

    private boolean canSplitArrayCore(String numStr, List<Integer> nums, int m, List<String> list) {
        if (list.size() == nums.size())
            return true;

        for (int i = 1; i < numStr.length(); i++) {
            if (check(numStr, nums, m, i)) {
                list.add(numStr.substring(0, i));
                if (canSplitArrayCore(numStr.substring(i), nums, m, list))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    private boolean check(String numStr, List<Integer> nums, int m, int i) {

        int res1 = 0;
        int count1 = 0;
        for (int j = 0; j < i; j++) {
            count1++;
            res1 += Integer.parseInt(numStr.charAt(j) + "");
        }

        int res2 = 0;
        int count2 = 0;
        for (int j = i; j < numStr.length(); j++) {
            count2++;
            res2 += Integer.parseInt(numStr.charAt(j) + "");
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if (count1 == 1 || res1 >= m)
            flag1 = true;
        if (count2 == 1 || res2 >= m)
            flag2 = true;

        return flag1 && flag2;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 2, 1);
        System.out.println(new T02SplitArray().canSplitArray(nums, 4));
    }
}
