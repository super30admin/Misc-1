//Time Complexity : O(N) for N is the total number of nested elements
//Space Complexity : O(D) for Stack Size and BFS
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/*
We can use the above fact to build our answer. Let dfs(node) be the excess number of coins in the subtree at or below this node: namely, the number of coins in the subtree, minus the number of nodes in the subtree. Then, the number of moves we make from this node to and from its children is abs(dfs(node.left)) + abs(dfs(node.right)). After, we have an excess of node.val + dfs(node.left) + dfs(node.right) - 1 coins at this node.

*/

public class DistributeCoinBinaryTree {

    int moves = 0;  
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int coins = root.val - 1;
        coins += dfs(root.left);
        coins += dfs(root.right);
        moves += Math.abs(coins);
        return coins;
    }
}