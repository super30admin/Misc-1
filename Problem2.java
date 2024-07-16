package Misc-1;
// TC: O(n)
// SC: O(h)
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        this.moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root){
        //base condition
        if(root==null) return 0;

        //logic 
        int extras = root.val - 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        moves += Math.abs(extras + left + right);
        return left + right + extras;
    }
}