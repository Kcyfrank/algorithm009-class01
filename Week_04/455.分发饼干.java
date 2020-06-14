/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 * 贪心||双指针
 * 优先关注未分配饼干的胃口最小的孩子
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
// @lc code=end

