import sun.net.www.content.audio.basic;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * 基础动规
 * 时间 Omn
 * 空间 On
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int m = grid.length; 
        int n = grid[0].length;
        //
        int[] dp = new int[n];
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j != n-1){
                    dp[j] = grid[i][j] + dp[j+1];
                }else if(i!=m-1&& j==n-1){
                    dp[j] = grid[i][j] + dp[j];
              } else if(i != m-1 && j != n-1){
                    dp[j] = grid[i][j] + Math.min(dp[j],dp[j+1]);
                }else{
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

