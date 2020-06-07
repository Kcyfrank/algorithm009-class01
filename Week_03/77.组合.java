/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 * 回溯剪枝
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new ArrayList<Integer>());
        return result;
    }


    private void findCombinations(int n, int k, int index, List<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.add(i);
            findCombinations(n, k, i + 1, p);
            p.remove(p.size()-1);
        }
    }
}
// @lc code=end

