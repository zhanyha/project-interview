package com.zyh.interview.algorithm.p7dp.a1basic;

import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 打家劫舍 II
 * @author：zhanyh
 * @date: 2023/5/4
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class C11HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int res1 = rob(root.left) + rob(root.right);
        int subResLeft = rob(root.left == null ? null : root.left.left) + rob(root.left == null ? null : root.left.right);
        int subResRight = rob(root.right == null ? null : root.right.left) + rob(root.right == null ? null : root.right.right);
        int res2 = root.val + subResLeft + subResRight;
        return Math.max(res1, res2);
    }
}
