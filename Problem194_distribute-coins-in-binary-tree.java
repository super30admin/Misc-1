// Bottom up recursion
// Time Complexity: O(n)
// Space Complexity: O(h)
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null) return moves;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root) {
        // base
        if(root == null) 
            return 0;
        
        // logic
        int extra = root.val - 1;
        extra += dfs(root.left);
        extra += dfs(root.right);
        moves += Math.abs(extra);
        return extra;
    }
}