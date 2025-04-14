// TC: O(n)
// SC: O(n)

public class LC979 {
    int moves = 0;
    private int distribute(TreeNode root) {
        if (root == null)
            return 0;
        int extra = root.val - 1;
        extra += distribute(root.left);
        extra += distribute(root.right);
        moves += Math.abs(extra);
        return extra;
    }

    public int distributeCoins(TreeNode root) {
        distribute(root);
        return moves;
    }
}
