package com.zyh.interview.algorithm.p5tree.a3binarysearchtree;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/4/25
 */
public class C04ArrayTobst {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTCore(nums, left, mid - 1);
        root.right = sortedArrayToBSTCore(nums, mid + 1, right);
        return root;
    }
}
