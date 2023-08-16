//Time Complexity (TC): O(N), where N is the number of nodes in the binary tree.

//Space Complexity (SC): O(H), where H is the height of the binary tree. In the worst case, the recursion depth can be equal to the height of the tree.

class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode root){
        //base
        if(root==null) return 0;
        
        //logic
        int extra = root.val-1;
        extra+= dfs(root.left);
        extra+= dfs(root.right);
        moves+= Math.abs(extra);
        
        return extra;
    }
}
