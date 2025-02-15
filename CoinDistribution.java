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
// Approach : Using DFS (Recursion) (Post Order/ Pre order) at every node calculate extra coins.
// When you hit the null then 0 extra coins. 
// ** We calculate number of moves by adding the absolute values of the number of coins each child needs to exchange with its parent node.
// In order is not trivial because looking from root we cannot determine how to optimally distribute the coins because we don't have
// enough information about the subtrees. 
// Time : O(n)
// Space : O(h) // Height of Tree 
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        this.moves = 0;
        dfs(root);
        return moves;
    }

    public int dfs(TreeNode root){
        // Base case
        if (root == null){
            return 0;
        }

        int extraCoins = root.val -1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        moves +=Math.abs(left + right + extraCoins);

        return left + right + extraCoins;
    }
}

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
// Approach : Using DFS (Recursion) (Post Order/ Pre order) at every node calculate extra coins.
// When you hit the null then 0 extra coins. 
// ** We calculate number of moves by adding the absolute values of the number of coins each child needs to exchange with its parent node.
// In order is not trivial because looking from root we cannot determine how to optimally distribute the coins because we don't have
// enough information about the subtrees. 
// Time : O(n)
// Space : O(h) // Height of Tree 
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        this.moves = 0;
        dfs(root);
        return moves;
    }

    public int dfs(TreeNode root){
        // Base case
        if (root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int extraCoins = root.val -1;

        moves +=Math.abs(left + right + extraCoins);

        return left + right + extraCoins;
    }
}