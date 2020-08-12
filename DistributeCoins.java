// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach:  As you do inorder traversal, calculate the spare coins you are left wiht at each node.
The spare would be the value -1. The moves will be the absolute value of the spare coins you get at each steps as you are either taking/ giving the 
coins from other node. 
*/
class Solution {
    int moves  = 0;
    int spare = 0;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        dfs(root);                                                                                  // Start exploring
        return moves;                                                                       // Return the moves
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int spare = root.val - 1;                                                               // Spare coins the node has
  //      System.out.println(spare);
        spare += dfs(root.left);                                                        // traversal of tree
        spare += dfs(root.right);
        moves += Math.abs(spare);                                                               // Increment your moves by spare
        return spare;
    }
}