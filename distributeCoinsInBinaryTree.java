// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class distributeCoinsInBinaryTree {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        // base
        if (node == null) return 0;
        // logic
        int spareCoins = node.val - 1;
        spareCoins += dfs(node.left);
        spareCoins += dfs(node.right);
        ans += Math.abs(spareCoins);
        return spareCoins;
    }
}