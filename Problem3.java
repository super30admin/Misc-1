// Time Complexity : O(N)
// Space Complexity : O(N)
// Passed Leetcode

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
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        Stack<NestedInteger> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        
        for (NestedInteger num : nestedList) {
            
            stack.add(num);
            depth.add(1);

        }
        int result = 0;
        while (!stack.isEmpty()) {
            
            NestedInteger curr = stack.pop();
            int currD = depth.pop();
            
            if (curr.isInteger()) {
                result += curr.getInteger() * currD;
            }
            else {
                for (NestedInteger child : curr.getList()) {
                    stack.add(child);
                    depth.add(currD+ 1);
                }
            }
            
        }
        
        return result;
        
    }
}