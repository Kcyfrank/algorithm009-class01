/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * one 2020 may 20
 * 时间复杂度 On^2
 * 空间复杂度 O1
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        //穷举 注意审题， 返回的是下标不是实际数字
        for (int i = 0; i < nums.length-1; i++) {
            result[0] = i;
            for (int j = i+1; j < nums.length; j++) {
                if(target == nums[result[0]]+nums[j]) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
// @lc code=end

