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
class CoinDistribution {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    
    private int result = 0;
    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root){
        if(root == null)
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result += Math.abs(left) + Math.abs(right);
        
        return root.val + left + right - 1;
    }
}