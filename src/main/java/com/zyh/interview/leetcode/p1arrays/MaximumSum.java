package com.zyh.interview.leetcode.p1arrays;

import javax.management.MXBean;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/6/27
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，
 * 然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 * <p>
 * 注意，删除一个元素后，子数组 不能为空。
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/
 */
public class MaximumSum {
    public static void main(String[] args) {
        TargetB targetB = new TargetB();
        new Thread(targetB).start();
        TargetA targetA = new TargetA();
        targetA.start();
    }

    static class TargetB implements Runnable{

        @Override
        public void run() {
            System.out.println("1");
        }
    }

    static class TargetA extends Thread{
        @Override
        public void run() {
            System.out.println("2");
        }
    }

}
