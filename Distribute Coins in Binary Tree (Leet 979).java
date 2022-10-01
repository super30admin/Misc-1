// Time: O(n)
// Space: O(h)

class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        moves += Math.abs(left+right-1+root.val);
        return left + right - 1 + root.val;
        
    }
    
}


class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        moves += Math.abs(left)+Math.abs(right);
        return left + right - 1 + root.val;
        
    }
    
}
