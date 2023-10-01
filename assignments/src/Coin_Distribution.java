// Approach: Bottom Up recursion.
// 1. On every node, extra = coins at node - 1.
// 2. On every node, moves += Math.abs(extra)
// Time: O(n)
// Space: O(H), H = height of tree

class Coin_Distribution {
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
        int extra = root.val - 1;
        extra += dfs(root.left);
        extra += dfs(root.right);
        moves += Math.abs(extra);
        return extra;
    }
}

// Definition for a binary tree node.
class TreeNode {
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