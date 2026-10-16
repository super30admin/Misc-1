/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
 */
class Solution {
    int moves;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int extra = 0;

        extra += dfs(node.left);

        extra += node.val - 1;

        extra += dfs(node.right);

        moves += Math.abs(extra);
        return extra;
    }
}