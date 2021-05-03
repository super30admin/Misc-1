// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if(node==null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        ans += Math.abs(l) + Math.abs(r);
        return node.val+l+r-1;
    }
}
