/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean[][] flag = new boolean[chars.length][chars.length];
        for (int j = 0; j < chars.length; j++) {
            for (int i = j; i >= 0; i--) { // i j 的值设定保证了只使用了 flag[][]的上三角，没有出现重复
                if (chars[i] == chars[j] && (j - i < 2 || flag[i + 1][j - 1])) {
                    flag[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

