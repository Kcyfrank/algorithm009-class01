/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    // /**
    //  * 暴力 每次把数组移动一位 移k次
    //  * 时间 O(n*k) On
    //  * 空间 O1
    //  */
    // public void rotate(int[] nums, int k) {
    //     int temp, previous;
    //     for (int i = 0; i < k; i++) {
    //         previous = nums[nums.length - 1];
    //         for (int j = 0; j < nums.length; j++) {
    //             temp = nums[j];
    //             nums[j] = previous;
    //             previous = temp;
    //         }
    //     }
    // }

    // /**
    //  * 环状替代 
    //  * 把元素的当前位置与k相加 并且与数组长度取余 即 移动后的实际位置
    //  * 交换位置
    //  */
    // public void rotate(int[] nums, int k) {
    //     k = k % nums.length;
    //     int count = 0;
    //     for (int start = 0; count < nums.length; start++) {
    //         int current = start;
    //         int prev = nums[start];
    //         do {
    //             int next = (current + k) % nums.length;
    //             int temp = nums[next];
    //             nums[next] = prev;
    //             prev = temp;
    //             current = next;
    //             count++;
    //         } while (start != current);
    //     }
    // }

    /**
     * 神奇的思路
     * 反转整个数组后
     * 再以k为中线分别反转前后部分既为移动的结果
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
// @lc code=end

