// Time Complexity: O(n) where n is number of elements in tree
// Space Complexity: O(d), depth of tree for stack space
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
        if(root == null) return 0;

        dfs(root);

        return moves;
    }

    private int dfs(TreeNode root) {
        // base case
        if(root == null) return 0;

        int extra = root.val - 1;

        extra += dfs(root.left);
        extra += dfs(root.right);
        moves += Math.abs(extra);

        return extra;
    }
}