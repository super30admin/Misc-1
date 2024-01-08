// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        for(NestedInteger el: nestedList){
            q.add(el);
            depth.add(1);
        }
        int result = 0;
        while(!q.isEmpty()){
            NestedInteger curr = q.poll();
            int currDepth = depth.poll();
            if(curr.isInteger()){
                result += curr.getInteger() * currDepth;
            } else {
                for(NestedInteger el: curr.getList()){
                    q.add(el);
                    depth.add(currDepth + 1);
                }
            }
        }
        return result;
    }
}