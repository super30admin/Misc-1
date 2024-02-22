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

/*Approach:
1. helper method pass the list
2. check if the element is integer? if so, get the integer, multiply with depth n d add it to result. 
3. else, just recursively call the helper ethod on the current lement which is list
TC: O(n) - nested Integers
SC: O(n) - same
*/
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        //base case
        if(nestedList == null)return 0;
        
        sum =0;
        helper(nestedList, 1);
        return sum;
    }
    
    private void helper(List<NestedInteger> nestedLists, int depth)
    {
        //base case no need, will be taken care by for loop
        
        //logic
        for(NestedInteger ni : nestedLists)
        {
            if(ni.isInteger())
                sum = sum + (ni.getInteger()*depth);
            else
                helper(ni.getList(), depth+1);
        }
        
    }
}