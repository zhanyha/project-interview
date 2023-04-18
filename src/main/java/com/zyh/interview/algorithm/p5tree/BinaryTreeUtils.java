package com.zyh.interview.algorithm.p5tree;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/4/17
 */
public class BinaryTreeUtils {
    public static TreeNode createTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTreeHelper(nums, 0);
    }
    private static TreeNode createTreeHelper(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = createTreeHelper(nums, 2 * index + 1);
        root.right = createTreeHelper(nums, 2 * index + 2);
        return root;
    }
}
