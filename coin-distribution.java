// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int sum;
    
    public int distributeCoins(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int L = helper(root.left);
        int R = helper(root.right);
        sum += Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
    }
}
