// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0
        }
        global = 0;
        dfs(root); 
        return moves;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int extra = root.val - 1;
        extra += dfs(root.left);
        extra += dfs(root.right);

        moves += Math.abs(extra);
        return extra;
    }
}