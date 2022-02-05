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


// Time complexity : DFS O(n) : Traversing each node once
// space complexity : O(h) : height of the tree, in worst case Skew : O(n)
class Solution {
    // Maximum number of moves
    int moves;
    public int distributeCoins(TreeNode root) {
        
        moves = 0;
        
        // Apply DFS
        dfs(root);
        
        return moves;
    }
    
    
    private int dfs(TreeNode root){
        
        if (root == null){
            
            return 0;
        }
        
        // Add all the flow from left sub tree , right sub tree and root val - 1
        // Since the value we need must be 1, the moves needed should be root.val - 1
        int flow = root.val - 1 + dfs(root.left) + dfs(root.right);
        
        // We need absoulte value of the flow as the child to parent will result in the negative value if the any root.val is 0.
        // As the moves will always be positive number
        moves += Math.abs(flow);
        
        
        return flow;
    }
}