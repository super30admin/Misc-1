//time complexity O(n) since we are visiting each node once
//space complexity O(n) in case of left skewed tree

class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    private int dfs(TreeNode root){
        //base
        if(root == null) return 0;
        //logic
        //basically we are calculating sparecoins at each node
        int spareCoins = root.val - 1;
        spareCoins += dfs(root.left);
        spareCoins += dfs(root.right);
        //abs value because it doesnt matter give or take. It's a move
        moves += Math.abs(spareCoins);
        //dfs returns sparecoins because that will be given to parent from left and right at each node
        return spareCoins;
    }
}
