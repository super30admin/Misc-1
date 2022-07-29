// Time Complexity : O(n)
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    
    int result;
    public int distributeCoins(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int extra = root.val - 1;
        
        extra += dfs(root.left);
        extra += dfs(root.right);
        
        result += Math.abs(extra);
        
        return extra;
    }
}