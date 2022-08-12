// Time Complexity : O(N)
// Space Complexity : O(H),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class DistributeCoinsInBinaryTree {
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
            moves = 0;
            dfs(root);
            return moves;
        }

        private int dfs(TreeNode root) {
            //base
            if(root == null) return 0;
            //logic
            int extraCoinsFromLeft = dfs(root.left);
            int extraCoinsFromRight = dfs(root.right);
            int extraCoinsAtRoot = extraCoinsFromLeft + root.val + extraCoinsFromRight - 1;
            moves += Math.abs(extraCoinsAtRoot);
            return extraCoinsAtRoot;
        }
    }
}
