/*
Distribute Coins in Binary Tree
approach: keep track of extra coins, moves would be the abs value of left extra coins and right extra coins
time: O(n)
space: O(h)
 */
public class Problem2 {
    int moves = 0;
/*    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if(root==null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        moves += Math.abs(left)+Math.abs(right);
        return left+right+(root.val-1);
    }*/
}
