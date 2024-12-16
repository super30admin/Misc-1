// Time complexity = O(n)
// Space complexity = O(h)
// logic - 
//the idea is to calculate the no. of moves with traversing the tree.
// So you take the no. of coins that can be returned from the left side to the parent
// Then you take no. of coins that can be returned from the right side to the parent
// Then you return the node value that you will return to the parent.
// that becomes your extra variable.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root) {
        if(root==null) return 0;
        int extra = root.val-1;
        extra += dfs(root.left);
        extra+= dfs(root.right);
        moves+= Math.abs(extra);
        return extra;
    }
}