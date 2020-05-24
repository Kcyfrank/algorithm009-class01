/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * one 2020 may 24
 * 时间复杂度 On
 * 空间复杂度 O1
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums== null){
            return 0;
        }
        int max= 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i]>nums[max-1]){
                nums[max] = nums[i];
                max++;
            }
        }
        return max;
    }
}
// @lc code=end

