// Time Complexity : O(N) where N is the no. of nodes in the tree
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// calculate the for each node the sum of no. of coins passed from left subtree and right sbutree
// And current - 1. This would be the no. of coins it has to pass
// To calculate the no. of moves we just add the no. of net coins passed from each level
// Finally we will return our count
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
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int curVal = root.val - 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int net = curVal + left + right;
        ans += Math.abs(net);
        return net;
    }
}