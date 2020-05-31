/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 * two 2020 may 26
 * 时间复杂度 On
 * 空间复杂度 O1
 */

// @lc code=start
class Solution {

    // 哈希表存储
    // 长度一致时，同时计算两者的字母数，一个加一个减，若为异位
    // 最后的结果必定都为0
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if(++map[cs[i]-'a'] == 1) count ++;
            if(--map[ct[i]-'a'] == 0) count --;
        }
        return count == 0;
    }

}
// @lc code=end

