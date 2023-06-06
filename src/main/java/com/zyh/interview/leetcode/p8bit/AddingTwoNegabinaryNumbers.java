package com.zyh.interview.leetcode.p8bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 1073. 负二进制数相加
 * @author：zhanyh
 * @date: 2023/5/18
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 * 1 <= arr1.length,arr2.length <= 1000
 * arr1[i]和arr2[i]都是0或1
 * arr1和arr2都没有前导0
 */
public class AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        List<Integer> res = new ArrayList<>();
        int p = m - 1, q = n - 1, c = 0;
        while (p >= 0 && q >= 0) {
            res.add((arr1[p] + arr2[q] + c) % 2);
            c = -(arr1[p] + arr2[q] + c) / 2;
            p--;
            q--;
        }
        while (p >= 0) {
            res.add((arr1[p--] + c) % 2);
            c = 0;
        }
        while (q >= 0) {
            res.add(arr1[q--] + c);
            c = 0;
        }
        res.add(c);
        int[] ans = new int[res.size()];
        for (int j = res.size() - 1; j >= 0; j--) {
            ans[res.size() - j - 1] = res.get(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i : new AddingTwoNegabinaryNumbers().addNegabinary(
                new int[]{1, 1, 1, 1, 1},
                new int[]{1,1, 1, 0, 1}
        )) {
            System.out.print(i + " ");
        }
    }
}
