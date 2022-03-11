// Time Complexity = O(n)
// Space Complexity = O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use bottom-up recursion using DFS in this question
// we collect the moves at each level and return the final moves at the end
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;

        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        // base
        if (root == null) return 0;

        // logic
        int excess = root.val - 1;  // we keep 1 for each node and the rest is excess
        excess += dfs(root.left);
        excess += dfs(root.right);
        moves += Math.abs(excess);
        return excess;
    }
}