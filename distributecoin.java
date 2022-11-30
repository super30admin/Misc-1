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
//TC O(N)
//SC O(H)
class Solution {
    public int distributeCoins(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int cnt){
        if (root == null) return cnt;
        root.val -= 1;
        int left = helper(root.left, cnt);
        int right = helper(root.right, cnt);
        if (root.left != null) root.val += root.left.val;
        if (root.right != null) root.val += root.right.val;
        return Math.abs(root.val) + Math.abs(left) + Math.abs(right);  
    } 
}