/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 * 时间On
 * 空间On
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        //当前节点为空 不可能为父节点 标记false
        if (root == null) {
            return false;
        }
        //判定当前节点的左子节点会否包含 p 或 q
        boolean lson = dfs(root.left, p, q);
        //判定当前节点的右子节点会否包含 p 或 q
        boolean rson = dfs(root.right, p, q);
        //仅当特定节点分别在当前节点的左右子树 ||  当前节点为特定节点 且另一节点在其子树下
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            //当前节点即最近公共子树
            ans = root;
        }
        //满足其中一个条件就标记当前分支为true
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }

}
// @lc code=end

