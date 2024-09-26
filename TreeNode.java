
 // Definition for a binary tree node.
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

class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
       dfs(root);
        return moves;
    }
    int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int extra= root.val-1;
        extra=extra+dfs(root.left);
        extra=extra+dfs(root.right);
        moves=moves+Math.abs(extra);
        return extra;
    }
}