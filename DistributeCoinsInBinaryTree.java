
//TC-O(N) SC-O(h)
public class DistributeCoinsInBinaryTree {
    int moves=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);

        moves=moves+Math.abs(left) + Math.abs(right);
        return root.val - 1 + left +right ;

    }
    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;     }
  }
}
