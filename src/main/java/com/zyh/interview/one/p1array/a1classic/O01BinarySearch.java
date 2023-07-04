package com.zyh.interview.one.p1array.a1classic;

/**
 * @description: 二分查找
 * @author：zhanyh
 * @date: 2023/6/28
 */
//https://www.nowcoder.com/practice/d3df40bd23594118b57554129cadf47b?tpId=196&tqId=38364&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE
public class O01BinarySearch {
    public int search (int[] nums, int target) {
        int l = 0, r = nums.length - 1;//[l, r]
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
