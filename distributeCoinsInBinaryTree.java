// Time Complexity : O(n)
// Space Complexity :O(n)

class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root){
        //base
        if(root==null){
            return 0;
        }
        
        int extra= root.val-1;
        extra+=dfs(root.left);
        extra+=dfs(root.right);
        moves=moves+Math.abs(extra);
        
        return extra;
    }
}