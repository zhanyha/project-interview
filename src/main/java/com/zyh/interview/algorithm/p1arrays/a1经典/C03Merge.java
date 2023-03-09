/**
 * @author zhanyuhao
 * @time 2023/2/7 14:19
 */
package com.zyh.interview.algorithm.p1arrays.a1经典;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">L88</a>
 * 输入：nums1 = [2,5,6,0,0,0,0], m = 3, nums2 = [1,3,3,7], n = 4
 * 输出：[1,2,3,3,5,6,7]
 */
public class C03Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0; // 处理nums1数组的当前元素
        int r = 0; // 处理nums2数组的当前元素
        int[] arr = new int[nums1.length];
        for (int i = 0; i < arr.length; i++) {
            if(l < m && r < n) {
                if (nums1[l] < nums2[r]) {
                    arr[i] = nums1[l];
                    l++;
                } else{
                    arr[i] = nums2[r];
                    r++;
                }
            }else{
               if(l < m){
                   arr[i] = nums1[l++];
               }else if(r < n){
                   arr[i] = nums2[r ++];
               }
            }
        }
        System.arraycopy(arr, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,6,0,0,0,0};
        int[] nums2 = new int[]{1,3,3,7};
        new C03Merge().merge(nums1,3, nums2, 4);
    }
}
