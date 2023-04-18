package com.zyh.interview.algorithm.p5tree;

/**
 * @description: 二叉树的最小深度
 * @author：zhanyh
 * @date: 2023/4/16
 */
public class C02MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return minDepthCore(root);
    }

    private int minDepthCore(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE - 1;
        if (root.left == null && root.right == null)
            return 1;
        int leftMinDepth = minDepthCore(root.left);
        int rightMinDepth = minDepthCore(root.right);
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, null, 20,null,null, 15, 7};
        TreeNode root = BinaryTreeUtils.createTree(nums);
        System.out.println(new C02MinDepth().minDepth(root));
    }

}
