// Time Complexity : The time complexity is O(n) where n is the number of nodes
// Space Complexity : Te space complexity is O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
        sum = 0;
        traverse(root);
        return sum;
    }

    public int traverse(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        //the number of children nodes that need coins is the number of moves
        sum += Math.abs(left+right+(root.val)-1);
        return left+right+(root.val)-1;
    }
}