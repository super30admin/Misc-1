//TC: O(n): post-order DFS visits each node once.
//SC: O(h): recursion stack proportional to tree height (O(n) worst-case, O(log n) balanced).

//Do a post-order DFS; for each node compute surplus = (node.val - 1) + surplus(left) + surplus(right).
//Moves needed at this node equal the absolute flow required by its children; accumulate into count.
//Return the surplus to the parent; the total count after DFS is the minimum moves.

class Solution {
    int count;
    public int distributeCoins(TreeNode root) {
        this.count = 0;
        helper(root);
        return count;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;

        int extras = root.val - 1;

        int left = helper(root.left);
        int right = helper(root.right);

        count += Math.abs(left + right + extras);

        return left + right + extras;
    }
}
