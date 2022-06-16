//Time Complexity O(N)
//Space Complexity O(1) 
//Leetcode tested

public class DistributeCoinsInBinaryTree {
    int num_moves;
    public int distributeCoins(TreeNode root) {
        num_moves = 0;
        giveCoins(root);
        return num_moves;
    }
    public int giveCoins(TreeNode root){
        if(root == null) return 0;
        int left = giveCoins(root.left);
        int right = giveCoins(root.right);
        num_moves += Math.abs(left) + Math.abs(right);
        return root.val + left + right -1;
    }
}
