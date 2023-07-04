package com.zyh.interview.one.p1array.a1classic;

import java.util.Arrays;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/28
 */
// https://www.nowcoder.com/practice/102586387caa4afcbad6f96affce9780?tpId=196&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=&judgeStatus=&tags=&title=%E7%A7%BB%E5%8A%A8&gioEnter=menu
public class O02MoveZeros {
    public int[] moveZeroes (int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                swap(nums, i, k);
                k++;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int k) {
        int t = nums[i];
        nums[i] = nums[k];
        nums[k] = t;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new O02MoveZeros().moveZeroes(new int[]{1, 0,2, 0, 0, 3})));
    }
}
