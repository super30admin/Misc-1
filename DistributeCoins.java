// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We perform DFS starting from root. The function dfs returns value of spare coins of subtree with root node
// The number of moves needed from this root node to and from its child nodes is absolute value of spare coins
// Once dfs is completed, return moves 
//
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
        
        if(root == null) return moves;
        
        dfs(root);
        
        return moves;
    }
    
    private int dfs(TreeNode root) {
        
        if(root == null) return 0;
        
        int spareCoins = root.val - 1;
        spareCoins += dfs(root.left);
        spareCoins += dfs(root.right);
        
        moves += Math.abs(spareCoins);
        
        return spareCoins;
    }
}