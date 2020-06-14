####学习笔记


##### 贪心算法 Greedy
贪心算法是一种在每一步选择中都采取在当前状态下最好或者最优（即最有利）的选择，从而希望导致结果是全局最好或者最优的算法。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能



#### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
按照当前给定的数组来说 半有序指的升序，那么无序的地方指的应该是第一个非升序点的下标

即找到当前0所在的位置，或者说找到第一个比 nums[0] 小的特殊点的下标

结束条件满足 `nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]` 条件



```$java
 public static int search(int[] nums) {
    int start = nums[0];
    int left = 0;
    int right = nums.length - 1;
    int mid = -1;

    while(left <= right) {
        mid = (left + right) / 2;
        if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
            return mid;
        }
        if (start>nums[mid]) {
            right = mid-1;
        } else {
            left = mid + 1;
        }
    }
    return mid;
}
```