/**
 * @author zhanyuhao
 * @time 2023/3/9 9:45
 */
package com.zyh.interview.leetcode.everyday;

/**
 * 输入：blocks = "BWBBWWBBBWBWWWBWWBBWBWBBWBB" , k = 11
 * 输出：3
 */
public class C001MinimumRecolorsL2379 {
    public int minimumRecolors(String blocks, int k) {
        int l = 0, blackCount = 0; //[l, r]
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B')
                blackCount++;
        }
        int res = k - blackCount;
        int t = res;
        while (l < blocks.length() - k) {
            if (blocks.charAt(l) != blocks.charAt(l + k)) {
                if (blocks.charAt(l) == 'W')
                    t--;
                else
                    t++;
                res = Math.min(res, t);
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new C001MinimumRecolorsL2379().minimumRecolors("BWBBWWBBBWBWWWBWWBBWBWBBWBB", 11));
    }
}
