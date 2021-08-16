class DistributeCoins {
    //time: O(n), where n= num of nodes
    //space: O(h), height of tree for recursive stack
    //did it run successfully on leetcode: yes
    
    //global variable to store no. of moves
    int moves;
    public int distributeCoins(TreeNode root) 
    {
        //initializing moves
        moves = 0;
        
        //if root is null
        if(root==null) return moves;
        
        //perform dfs on root
        dfs(root);
        
        return moves;
    }
    
    private int dfs(TreeNode root){
        
        //base
        //root is null
        if(root == null) return 0;
        
        //logic
        //num of extra coins
        int extras = root.val - 1;
        
        //add extra coin got from left child
        extras  += dfs(root.left);
        
        //add extra coin got from right child
        extras  += dfs(root.right);
        
        //update moves count
        moves += Math.abs(extras);
        
        //return extra coins that we have for current node
        return extras;
    }
}