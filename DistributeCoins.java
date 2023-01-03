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
 //Time - O(n)
 //sapce - O(logn)
class Solution {
    int moves =0;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return moves;
    }
    int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int extra = left+right+root.val-1;
        moves+= Math.abs(extra);
        return extra;
    }
}