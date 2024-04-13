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

    int count = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return count;
    }

    public int helper(TreeNode root) {
        if(root.left == null && root.right == null) {
            count += Math.abs(root.val - 1);
            return root.val - 1;
        }
        if(root.left != null) root.val += helper(root.left);
        if(root.right != null) root.val += helper(root.right);
        int val = root.val - 1;
        count += Math.abs(val);
        return val;
    }
}
