// Time Complexity : O(n) where n is the length of the list
// Space Complexity : O(n) where n is the length of the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class nestedListWeightSum_DFS {
    int ans;
    public int depthSum(List<NestedInteger> nestedList) {
        ans = 0;
        dfs(nestedList, 1);
        return ans;
    }
    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger curr : nestedList) {
            if (curr.isInteger()) {
                ans += curr.getInteger() * depth;
            } else {
                dfs(curr.getList(), depth + 1);
            }
        }
    }
}