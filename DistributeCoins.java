
/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Compute the number of extra coins:
extra = node.val - 1
(since 1 coin is needed per node)

Add the surplus/deficit from the left and right subtrees recursively.

Update the total number of moves by adding the absolute value of extra, because each extra coin moved (in or out) counts as one move.
 */

public class DistributeCoins {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        // base
        if (node == null)
            return 0;
        
        // logic
        int extra = node.val - 1;
        extra += dfs(node.left);
        // int extra = dfs(node.left);
        // extra += node.val - 1;
        extra += dfs(node.right);
        moves += Math.abs(extra);
        return extra;
    }
    public static void main(String[] args) {
        // Your code here
    }
}