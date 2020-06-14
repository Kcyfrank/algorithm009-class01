/**
 * 二分
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null | nums.length == 0) {
            return -1;
        }
        int a0 = nums[0];
        int l = 0;
        int r = nums.length - 1;
        if (a0 == target) {
            return 0;
        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if ((a0 < target && target < nums[mid])
                || (target < nums[mid] && nums[mid] < a0)
                || (nums[mid] < a0 && a0 < target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l == r && target == nums[l] ? l : -1;
    }
}