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

 /*
 
 The question states that there are n nodes, and total n coins distributed among the nodes. 
 Each node should only have 1 coin on them . We need to distruibute the coins among the nodes, doing minimum number of moves

 Intuition:

 We need to look at each subtree, how much extra it has , we will calculate extra as left.val + (current.val -1) + right.val. what ever the result is, would be the extra amount, so  those many would be the number of moves. If the amount is negative, then it means it needs that many, so we will always take absolute value.

 We will traverse the tree in DFS manner, calculatin the extra and keep adding the aboslutue of the extra to the number of moves.

 Whicever the number of moves we may get, we will the minimum number of moves

 Time: O(n) 
 Space : O(n) // when tree is skewed the recursive stack would take that much

 */
class Solution {
    int min = 0;
    public int distributeCoins(TreeNode root) {

        helper(root);

        return min;
        
    }

    private int helper(TreeNode node){
        //base
        if(node == null){
            return 0;
        }

        //logic
        int extra = node.val - 1; // taking 1 and whatever is left is extra
        //recurse
        extra += helper(node.left);
        extra += helper(node.right);
        
        min += Math.abs(extra);

        return extra;
    }
}