// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate over the nested integer list 
// If it is current value is of integer type add the product of this and depth to sum
// Otherwise call the method recursively passing the value
// Finally return the sum
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
        return dfs(nestedList, 1);
    }
    public int dfs(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        for(NestedInteger x: nestedList){
            if(x.isInteger())
                sum += x.getInteger() * depth;
            else{
                sum += dfs(x.getList(), depth + 1);
            }
        }
        return sum;
    }
}