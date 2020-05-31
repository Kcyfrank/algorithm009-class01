/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * two 2020 may 31
 * 时间复杂度 On
 * 空间复杂度 On
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // 该异常是否有意义？
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end

