public class problem2 {

    // Time complexity: O(n)
    // Space Complexity: O(h)
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
  int moves=0;
    public int distributeCoins(TreeNode root) {
        this.moves=0;
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        int extras= root.val-1;
        int left= distributeCoins(root.left);
        int right= distributeCoins(root.right);
        return extras+left+right;
    }

}
