package com.zyh.interview.leetcode.p9math;

/**
 * @description: 圆和矩形是否有重叠
 * @author：zhanyh
 * @date: 2023/6/25
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形存在公共点 (1,0) 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circle-and-rectangle-overlapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckSquareCircleOverlap {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int i = Math.min(x1, x2); i < Math.max(x1, x2); i++) {
            for (int j = Math.min(y1, y2); j < Math.max(y1, y2); j++) {
                if((i - xCenter) * (i - xCenter) + (j - yCenter) * (j - yCenter) <= radius * radius){
                    return true;
                }
            }
        }
        return false;
    }
}
