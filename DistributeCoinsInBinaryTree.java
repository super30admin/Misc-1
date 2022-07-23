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

    //Time Complexity: 0(n) where n is the no. of nodes in the in the tree
    //Space complexity : 0(h) where h is the height of the tree

    int moves;  //a global variable to capture the no. of moves to distribute coins to all nodes equally
    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }

        moves = 0;  //initializing
        dfs(root);  //calling my recursive method

        return moves;   //returning the answer at the end
    }

    public int dfs(TreeNode root){
        //base
        if(root == null){
            return 0;
        }
        //logic
        int extra = root.val - 1;   //this will calculate the extra coins a node has

        extra += dfs(root.left);    //calling the dfs on left node. Also adding extra to it as the coins will be carry forwarded
        extra += dfs(root.right);   //calling dfs on right node
        moves += Math.abs(extra);   //taking the absoulte value of extra and adding it to moves by doing a bottom up recursion

        return extra;   //returning extra as the extra coins are carry forwarded to next nodes to distribute
    }
}