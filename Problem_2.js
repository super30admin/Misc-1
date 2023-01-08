
// ## Problem2: Coin distribution(https://leetcode.com/problems/distribute-coins-in-binary-tree/)

// TC: O(n)
// SC: O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
let moves;
/**
 * @param {TreeNode} root
 * @return {number}
 */
var distributeCoins = function (root) {
    if (root === null)
        return 0;
    moves = 0;
    let dummyRoot = root;
    dfs(dummyRoot);
    return moves

};
var dfs = (root) => {
    // Bottom up approach
    // If root is null, return o
    if (root === null)
        return 0;

    // Get coins from left
    let left = dfs(root.left);
    // Get coins from right
    let right = dfs(root.right);
    // Add the coins to moves
    moves += Math.abs(left);
    moves += Math.abs(right);

    // Root value will gain based on values from left and right
    root.val = root.val + left + right;

    // This will keep 1 coin and return others, if it is 0, it will return -1 indicating that it needs 1 coin
    return root.val - 1;
}