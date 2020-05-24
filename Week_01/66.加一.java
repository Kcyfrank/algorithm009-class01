/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 * one 2020 may 19
 * 时间复杂度 On
 * 空间复杂度 On
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        //动手太快。。漏读条件。。 
        //*每个元素只存储单个数字*
        //思路 暴力，尾数加一 反向循环进一
        int size = digits.length;
        for (int i = size - 1 ; i >= 0 ; i--) {
            digits[i] += 1;
            if (digits[i] != 10) {
               return digits;
            }
            digits[i] = 0;
        }
        //数组为9 9，9 9，9，9时 数组加一位
        digits = new int[size + 1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end

