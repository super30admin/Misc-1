//TC : O(N) and SC : O(H) - height of the tree
class Solution {
    int minMoves;
    public int distributeCoins(TreeNode root) {
        if(root == null)    return 0;
        
        helper(root);
        return minMoves;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int currExtra = root.val - 1; // At cuurent node root, how many extra coinsd it is having
        currExtra += helper(root.left);
        currExtra += helper(root.right);
        
        minMoves += Math.abs(currExtra); // No. of extra coins == No. of moves from that node
        return currExtra;
    }
}