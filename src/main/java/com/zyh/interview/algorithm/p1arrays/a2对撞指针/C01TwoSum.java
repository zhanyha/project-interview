/**
 * @author zhanyuhao
 * @time 2023/2/7 14:42
 */
package com.zyh.interview.algorithm.p1arrays.a2对撞指针;

//https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
public class C01TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0 , r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] == target)
                return new int[]{l+1, r+1};
            else if(numbers[l] + numbers[r] < target)
                l++;
            else
                r--;
        }
        return null;
    }
}
