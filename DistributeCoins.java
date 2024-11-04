// Problem 979. Distribute Coins in Binary Tree
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
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
    public int distributeCoins(TreeNode root) {
        int[] moves = new int[1];
        dfs(root, moves);
        return moves[0];
    }

    private int dfs(TreeNode node, int[] moves) {
        if (node == null) return 0;
        int left = dfs(node.left, moves);
        int right = dfs(node.right, moves);
        moves[0] += Math.abs(left) + Math.abs(right);
        return node.val - 1 + left + right;
    }
}