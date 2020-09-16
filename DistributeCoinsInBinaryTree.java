// Time Complexity : O(n) --> where n is the number of nodes in the tree
// Space Complexity : O(h) --> where h is the depth/height of the tree
// Did this code successfully run on Leetcode (979): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        if (root == null) return moves;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root) {
        // base case
        if (root == null) return 0;
        
        // logic
        int spareCoins = root.val - 1;
        spareCoins += dfs(root.left);
        spareCoins += dfs(root.right);
        moves += Math.abs(spareCoins);
        return spareCoins;
    }
}