package com.zyh.interview.algorithm.p5tree.a2complexer;

import com.zyh.interview.algorithm.p5tree.BinaryTreeUtils;
import com.zyh.interview.algorithm.p5tree.TreeNode;

/**
 * @description: 和C03TreePathsSumII.java 不同的是， 这里的路径和不需要必须到达叶子节点
 * @author：zhanyh
 * @date: 2023/4/24
 */
public class C05PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null)
            return 0;
        res += findPath(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    private int findPath(TreeNode root, long targetSum) {
        int res = 0;
        if (targetSum == root.val)
            res += 1;
        if(root.left != null)
            res += findPath(root.left, targetSum - root.val);
        if(root.right != null)
            res += findPath(root.right, targetSum - root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = BinaryTreeUtils.createTree(new Integer[]{5, 3, 2, -1, -2, null, 1});
        System.out.println(new C05PathSumIII().pathSum(tree, 8));
    }
}
