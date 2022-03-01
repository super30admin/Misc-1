/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //o(n)time and const space
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        if(root == null) return moves;
        dfs(root);
        return moves;
    }
    private int dfs(TreeNode root){

        if (root == null) return 0;

        int extra = root.val-1;
        extra += dfs(root.left);
        extra+= dfs(root.right);
        moves += Math.abs(extra);
        return extra;
    }
}
class Solution {
    int result;
    public int depthSum(List<NestedInteger> nestedList) {
        //o(n) time and O(h) recursion stack space
        result = 0;
        dfs(nestedList, 1);
        return result;
    }
    private void dfs(List<NestedInteger> nestedList, int depth){

        for(NestedInteger el: nestedList){
            if(el.isInteger()){
                result += depth  * el.getInteger();
            } else {
                dfs(el.getList(), depth + 1 );
            }
        }
    }

class Solution {
    public int brokenCalc(int startValue, int target) {
        //o(logn) time
        int count = 0;
        if(startValue == target) return count;

        while(target > startValue){
            if(target % 2 == 0) {
                target = target /2;
            } else {
                target++;
            }
            count++;
        }

        return count + startValue - target;
    }
}