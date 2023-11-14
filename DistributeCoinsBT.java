import javax.swing.tree.TreeNode;
// Using DFS
// Time Complexity: O(N)
// Space Complexity: O(H)
public class DistributeCoinsBT {
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return moves;
        
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int extra = root.val - 1;
        extra += dfs(root.left);
        extra +=dfs(root.right);    
        moves += Math.abs(extra);
        return extra;
    }
}
