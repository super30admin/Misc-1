//time compleexity: O(n)
//space complexity: O(n)
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
    int sum;
    public int distributeCoins(TreeNode root) {
        sum=0;
        dfs(root);
        return sum;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        int extra=left+root.val-1+right;
        sum+=Math.abs(extra);
        return extra;
    }
}