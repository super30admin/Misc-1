//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code run successfully on leetcode : Yes
//Have you faced any issue while rwriting this code : No
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
        this.moves = 0;
        dfs(root);
        return moves;
        
    }

    private int dfs(TreeNode root) {
        //base case
        if(root == null) return 0;

        //logic
        int extras = root.val - 1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        moves += Math.abs(extras+left+right);
        return extras+left+right;
    }
}