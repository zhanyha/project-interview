package com.zyh.interview.algorithm.p9classic;

/**
 * @description: 约瑟夫环问题
 * @author：zhanyh
 * @date: 2023/6/8
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class C01LastRemaining {

    public int lastRemaining(int n, int m) {
        int res = 0; // 最后只剩下一个元素的时候，这个最终保留下来的数字一定是0
        // 上一次元素的个数从2 ~ n;
        // 推导最终保留下来的数字在最原始数组中的位置
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        // res 是下标， 最终返回的是值
        // 但是n的含义刚好是0~n-1
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new C01LastRemaining().lastRemaining(10, 17));
    }
}
