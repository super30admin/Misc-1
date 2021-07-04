/*


Did it run leet code: yes
Did you face any problem: No

Time Complexity: 0(N)
Space Complexity: 0(log(N))

Algorithm:
- If a node has coins more than 1, then no of moves required to coins=1 for that node will be node.val-1
- if a node has 0 coins then it requires 1 move to get one coin.
- We make a post order traversal of the tree an calculate to get number of moves.
- After, we have an excess of node.val + dfs(node.left) + dfs(node.right) - 1 coins at this node.


*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        dfsHelper(root);
        return moves;
    }
    
    public int dfsHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int giveAwayCoins = root.val-1;
        giveAwayCoins += dfsHelper(root.left);
        giveAwayCoins += dfsHelper(root.right);
        
        moves +=Math.abs(giveAwayCoins);
        return giveAwayCoins;
    }
}