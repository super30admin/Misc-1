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
        if(root == null)
            return -1;
        
        moves = 0;
        
        give_coins(root);
        
        return moves;
        
    }
    
    public int give_coins(TreeNode root){
        //base
        if(root == null)
            return 0;
        
        //logic
        int extras = root.val -1;
        extras += give_coins(root.left);
        extras += give_coins(root.right);
        moves += Math.abs(extras);
        
        return extras;
        
    }
}
