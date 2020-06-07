/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxPath=0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        this.getDepth(root, 0);
        return maxPath;
    }

    private void getDepth(TreeNode node, int curDep){
        curDep++;
        if(node.left == null && node.right == null){
            if(maxPath< curDep) maxPath = curDep;
            return;
        }

        if(node.left != null) {
            getDepth(node.left, curDep);
        } 
        if(node.right != null) {
            getDepth(node.right, curDep);
        }    
    }
}
// @lc code=end

