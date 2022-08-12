// Time Complexity : O(N)
// Space Complexity : O(N), dfs stack whose size is maximum number of nesting
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class NestedListWeightSum {
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
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    class Solution {
        int result;
        public int depthSum(List<NestedInteger> nestedList) {
            result = 0;
            int depth = 1;
            dfs(nestedList, depth);
            return result;
        }

        private void dfs(List<NestedInteger> nestedList, int depth) {
            for(int i=0; i< nestedList.size(); i++) {
                NestedInteger el = nestedList.get(i);
                if(el.isInteger()) {
                    result += (el.getInteger()) * depth;
                } else {
                    dfs(el.getList(), depth+1);
                }
            }
        }
    }
}
