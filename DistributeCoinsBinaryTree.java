
// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DFS
class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int L = dfs(root.left);
        int R = dfs(root.right);
        
        res += Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
    }
}