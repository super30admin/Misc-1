public class Coindistribution {
    
    int steps;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        steps = 0;
        helper(root);
        return steps;
    }
    
    //
    //TC: O(N) Visiting all the nodes
    //SC: O(H) in the recursive stack maximum it would be height of the tree.
    private int helper(TreeNode root) {
        if(root == null) { return 0; }
        
        int remainingCoins = root.val -1;
        remainingCoins += helper(root.left);
        remainingCoins += helper(root.right);
        steps += Math.abs(remainingCoins);
        return remainingCoins;
    }
    
    public static void main(String[] args) {
        Coindistribution coindistribution = new Coindistribution();
        int result = coindistribution.distributeCoins(new TreeNode().getSampleBST())
        System.out.println("The result: "+result);
    }
}
