//TC: O(n)
//SC: O(1)
/*Approach : Here you start at the root nodes and gather the extra coins and send it to the root, root.val + L + R - 1,  we do this recursively */

class Solution {
    int sum;
    public int distributeCoins(TreeNode root) {
        sum=0;
        helper(root);
        return sum;
    }
    
    private int helper(TreeNode root){
        
        if(root==null) return 0;
        
        int L = helper(root.left);
        int R = helper(root.right);
        
        sum += Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
        
    }
}
