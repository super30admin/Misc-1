
TC:O(n)
SC:O(n)

148 / 148 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 38.6 MB

Approach: Do a post order traversal and find the amount of coinst that are in excess in each node.Increase the moves by the abs value of
each giveaway from each node



class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        recursion(root);
        return moves;
        
    }
    private int recursion(TreeNode root){
        if(root == null ) return 0;
        
        
        int Giveawaycoins = root.val-1;
        
        Giveawaycoins += recursion(root.left);
        Giveawaycoins += recursion(root.right);
        
        moves += Math.abs(Giveawaycoins);
        
        return Giveawaycoins;
        
        
    }
}
