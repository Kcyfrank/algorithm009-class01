/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 * 贪心
 * 时间 ON
 * 空间 O1
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //设定最大到达点
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            //未到达之前 并且当前点为可到达
            if (i <= rightmost) {
                //从i=0开始 计算当前最大能到达的位置
                rightmost = Math.max(rightmost, i + nums[i]);
                //抵达终点结束
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

