import javax.swing.tree.TreeNode;

public class CoinDistribution {

//Time Complexity:O(n)
//Space Complexity:O(h)
//For each node, calculate how many coins are extra or needed (val - 1).
//Then collect moves from left and right subtrees recursively.
//Add the absolute value of net coin movement to the total count at every node.
    int count = 0;
    public int distributeCoins(TreeNode root)
    {
        this.count = 0;
        helper(root);
        return count;
    }

    private int helper(TreeNode root)
    {
        if(root==null) return 0;
        
        int extras = root.val - 1;
        int left = helper(root.left);
        int right = helper(root.right);

        count += Math.abs(left+right+extras);

        return left+right+extras;
    }
}
