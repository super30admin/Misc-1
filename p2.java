// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

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
    int result = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;

        //extra coins on the current node and left node and right node
        int extra = node.val-1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        extra = left + extra + right;
        //We would have to move that much coins, add it to the result
        result = result + Math.abs(extra);
        return extra;
    }
}