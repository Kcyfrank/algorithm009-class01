/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        
        if (s.length() <= 26) {
            int[] charNum = new int[26];
            char[] chars = s.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                charNum[chars[i] - 'a']++;
            }
            for (int i = 0; i < length; i++) {
                if (charNum[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }

        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }
}

// @lc code=end

