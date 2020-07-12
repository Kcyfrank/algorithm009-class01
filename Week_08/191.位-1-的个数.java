/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones++;
            n &= n - 1;
        }
        return ones;
    }
}
// @lc code=end

