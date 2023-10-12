// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

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


public class DistributeCoinsInABinaryTree {
    int moves;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }

    private int helper(TreeNode root){

        // base
        if(root == null) return 0;
        int extras = root.val-1;
        extras += helper(root.left);
        extras += helper(root.right);

        moves += Math.abs(extras);

        return extras;

    }
}