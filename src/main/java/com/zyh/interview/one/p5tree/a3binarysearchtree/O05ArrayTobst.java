package com.zyh.interview.one.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/8/4
 */
public class O05ArrayTobst {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTCore(int[] nums, int left, int right){
        if(left <= right){
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBSTCore(nums, left, mid - 1);
            root.right = sortedArrayToBSTCore(nums, mid + 1, right);
            return root;
        }
        return null;
    }

}
