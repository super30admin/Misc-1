// Time Complexity : O(N) 
// Space Complexity : O(H) Height of tree
// Passed Leetcode

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
    
    public int helper(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int extra = root.val - 1;
        
        extra += helper(root.left);
        extra += helper(root.right);
        
        moves += Math.abs(extra);
        return extra;
    }
    
    public int distributeCoins(TreeNode root) {
        moves = 0;
        if (root == null)
            return moves;
        helper(root);
        return moves;
    }
}